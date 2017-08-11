package com.iambedant.instantappstarter.injection.module;
import com.iambedant.instantappstarter.data.AppDataManager;
import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.data.local.pref.AppPreferencesHelper;
import com.iambedant.instantappstarter.data.local.pref.PreferencesHelper;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by @iamBedant on 11/08/17.
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    PreferencesHelper provideSharedPrefs(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

}
