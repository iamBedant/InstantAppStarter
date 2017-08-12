package com.iambedant.instantappstarter.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.iambedant.instantappstarter.data.AppDataManager;
import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.data.local.pref.AppPreferencesHelper;
import com.iambedant.instantappstarter.data.local.pref.PreferencesHelper;
import com.iambedant.instantappstarter.data.remote.ApiHelper;
import com.iambedant.instantappstarter.data.remote.AppApiHelper;
import com.iambedant.instantappstarter.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Module
public class AppModule {


    private final Context context;

    public AppModule(Application app) {
        this.context = app;
    }

    @Provides
    @ApplicationContext
    public Context providesContext() {
        return context;
    }

    @Provides
    public Resources providesResources(Context context) {
        return context.getResources();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
