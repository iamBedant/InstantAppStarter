package com.iambedant.instantappstarter.data.local.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.iambedant.instantappstarter.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by iamBedant on 6/28/2016.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper{

    public static final String PREF_FILE_NAME = "_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context) {

        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//        mPref = ObscuredSharedPreferences.getPrefs(context, PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public String getString(String KEY, String DEFAULT) {
        return mPref.getString(KEY, DEFAULT);
    }

    public void putString(String KEY, String VALUE) {
        mPref.edit().putString(KEY, VALUE).apply();
    }

    public void putDouble(String KEY, Double VALUE) {
        mPref.edit().putLong(KEY, Double.doubleToRawLongBits(VALUE)).apply();
    }
    public Double getDouble(String KEY, Double DEFAULT){
        return Double.longBitsToDouble(mPref.getLong(KEY, Double.doubleToLongBits(DEFAULT)));
    }

    public Boolean getBoolean(String KEY, Boolean DEFAULT) {
        return mPref.getBoolean(KEY, DEFAULT);
    }

    public void putBoolean(String KEY, Boolean VALUE) {
        mPref.edit().putBoolean(KEY, VALUE).apply();
    }

    //Implementation

    @Override
    public String getCurrentUserId() {
        return getString("default","default");
    }

    @Override
    public void setCurrentUserId(String id) {
        putString("default",id);
    }
}
