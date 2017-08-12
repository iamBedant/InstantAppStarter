package com.iambedant.instantappstarter.data;


import android.content.Context;

import com.iambedant.instantappstarter.data.local.pref.PreferencesHelper;
import com.iambedant.instantappstarter.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public String getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(String id) {
        mPreferencesHelper.setCurrentUserId(id);
    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
