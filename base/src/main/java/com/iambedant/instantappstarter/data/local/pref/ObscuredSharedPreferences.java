package com.iambedant.instantappstarter.data.local.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.util.Base64;
import android.util.Log;

import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * Created by @iamBedant on 01/11/16.
 */

public class ObscuredSharedPreferences implements SharedPreferences {
    protected static final String UTF8 = "UTF-8";
    //this key is defined at runtime based on ANDROID_ID which is supposed to last the life of the device
    private static char[] SEKRIT=null;


    protected SharedPreferences delegate;
    protected Context context;
    private static ObscuredSharedPreferences prefs = null;

    //Set to true if a decryption error was detected
    //in the case of float, int, and long we can tell if there was a parse error
    //this does not detect an error in strings or boolean - that requires more sophisticated checks
    public static boolean decryptionErrorFlag = false;

    /**
     * Constructor
     * @param context
     * @param delegate - SharedPreferences object from the system
     */
    public ObscuredSharedPreferences(Context context, SharedPreferences delegate) {
        this.delegate = delegate;
        this.context = context;
        SEKRIT = Secure.ANDROID_ID.toCharArray();
    }

    /**
     * Only used to change to a new key during runtime.
     * If you don't want to use the default per-device key for example
     * @param key
     */
    public static void setNewKey(String key) {
        SEKRIT = key.toCharArray();
    }

    /**
     * Accessor to grab the preferences in a singleton.  This stores the reference in a singleton so it can be accessed repeatedly with
     * no performance penalty
     * @param c - the context used to access the preferences.
     * @param appName - domain the shared preferences should be stored under
     * @param contextMode - Typically Context.MODE_PRIVATE
     * @return
     */
    public synchronized static ObscuredSharedPreferences getPrefs(Context c, String appName, int contextMode) {
        if (prefs == null) {
            //make sure to use application context since preferences live outside an Activity
            //use for objects that have global scope like: prefs or starting services
            prefs = new ObscuredSharedPreferences(
                    c.getApplicationContext(), c.getApplicationContext().getSharedPreferences(appName, contextMode) );
        }
        return prefs;
    }

    public class Editor implements SharedPreferences.Editor {
        protected SharedPreferences.Editor delegate;

        public Editor() {
            this.delegate = ObscuredSharedPreferences.this.delegate.edit();
        }

        @Override
        public Editor putBoolean(String key, boolean value) {
            delegate.putString(key, encrypt(Boolean.toString(value)));
            return this;
        }

        @Override
        public Editor putFloat(String key, float value) {
            delegate.putString(key, encrypt(Float.toString(value)));
            return this;
        }

        @Override
        public Editor putInt(String key, int value) {
            delegate.putString(key, encrypt(Integer.toString(value)));
            return this;
        }

        @Override
        public Editor putLong(String key, long value) {
            delegate.putString(key, encrypt(Long.toString(value)));
            return this;
        }

        @Override
        public Editor putString(String key, String value) {
            delegate.putString(key, encrypt(value));
            return this;
        }

        @Override
        public void apply() {
            //to maintain compatibility with android level 7
            delegate.commit();
        }

        @Override
        public Editor clear() {
            delegate.clear();
            return this;
        }

        @Override
        public boolean commit() {
            return delegate.commit();
        }

        @Override
        public Editor remove(String s) {
            delegate.remove(s);
            return this;
        }

        @Override
        public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
            throw new RuntimeException("This class does not work with String Sets.");
        }
    }

    public Editor edit() {
        return new Editor();
    }


    @Override
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException(); // left as an exercise to the reader
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        //if these weren't encrypted, then it won't be a string
        String v;
        try {
            v = delegate.getString(key, null);
        } catch (ClassCastException e) {
            return delegate.getBoolean(key, defValue);
        }

        return v!=null ? Boolean.parseBoolean(decrypt(v)) : defValue;
    }

    @Override
    public float getFloat(String key, float defValue) {
        String v;
        try {
            v = delegate.getString(key, null);
        } catch (ClassCastException e) {
            return delegate.getFloat(key, defValue);
        }
        try {
            return Float.parseFloat(decrypt(v));
        } catch (NumberFormatException e) {
            //could not decrypt the number.  Maybe we are using the wrong key?
            decryptionErrorFlag = true;
            Log.e(this.getClass().getName(), "Warning, could not decrypt the value.  Possible incorrect key.  "+e.getMessage());
        }
        return defValue;
    }

    @Override
    public int getInt(String key, int defValue) {
        String v;
        try {
            v = delegate.getString(key, null);
        } catch (ClassCastException e) {
            return delegate.getInt(key, defValue);
        }
        try {
            return Integer.parseInt(decrypt(v));
        } catch (NumberFormatException e) {
            //could not decrypt the number.  Maybe we are using the wrong key?
            decryptionErrorFlag = true;
            Log.e(this.getClass().getName(), "Warning, could not decrypt the value.  Possible incorrect key.  "+e.getMessage());
        }
        return defValue;
    }

    @Override
    public long getLong(String key, long defValue) {
        String v;
        try {
            v = delegate.getString(key, null);
        } catch (ClassCastException e) {
            return delegate.getLong(key, defValue);
        }
        try {
            return Long.parseLong(decrypt(v));
        } catch (NumberFormatException e) {
            //could not decrypt the number.  Maybe we are using the wrong key?
            decryptionErrorFlag = true;
            Log.e(this.getClass().getName(), "Warning, could not decrypt the value.  Possible incorrect key.  "+e.getMessage());
        }
        return defValue;
    }

    @Override
    public String getString(String key, String defValue) {
        final String v = delegate.getString(key, null);
        return v != null ? decrypt(v) : defValue;
    }

    @Override
    public boolean contains(String s) {
        return delegate.contains(s);
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        delegate.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        delegate.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override
    public Set<String> getStringSet(String key, Set<String> defValues) {
        throw new RuntimeException("This class does not work with String Sets.");
    }


    protected String encrypt(String value ) {

        try {
            final byte[] bytes = value!=null ? value.getBytes(UTF8) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(Secure.getString(context.getContentResolver(), Secure.ANDROID_ID).getBytes(UTF8), 20));
            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP),UTF8);
        } catch( Exception e ) {
            throw new RuntimeException(e);
        }

    }

    protected String decrypt(String value){
        try {
            final byte[] bytes = value!=null ? Base64.decode(value, Base64.DEFAULT) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(Secure.getString(context.getContentResolver(), Secure.ANDROID_ID).getBytes(UTF8), 20));
            return new String(pbeCipher.doFinal(bytes),UTF8);
        } catch( Exception e) {
            Log.e(this.getClass().getName(), "Warning, could not decrypt the value.  It may be stored in plaintext.  "+e.getMessage());
            return value;
        }
    }
}