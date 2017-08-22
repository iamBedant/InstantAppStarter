package com.iambedant.instantappstarter.data;


import android.content.Context;

import com.iambedant.instantappstarter.data.local.pref.PreferencesHelper;
import com.iambedant.instantappstarter.data.remote.ApiHelper;
import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.data.remote.model.newsSource.NewsSources;
import com.iambedant.instantappstarter.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
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

    @Override
    public Observable<UserResponse> doLogin(UserRequest request) {
        return mApiHelper.doLogin(request);
    }

    @Override
    public Observable<NewsSources> loadSources() {
        return mApiHelper.loadSources();
    }
}
