package com.iambedant.instantappstarter;

import android.app.Application;

import com.iambedant.instantappstarter.injection.components.ActivityComponent;
import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.injection.components.DaggerAppComponent;
import com.iambedant.instantappstarter.injection.components.FragmentComponent;
import com.iambedant.instantappstarter.injection.modules.ActivityModule;
import com.iambedant.instantappstarter.injection.modules.AppModule;
import com.iambedant.instantappstarter.injection.modules.FragmentModule;

/**
 * Created by @iamBedant on 11/08/17.
 */

public class App extends Application {

    private AppComponent appComponent;
    private ActivityComponent activityComponent;
    private FragmentComponent fragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ActivityComponent createActivityComponent() {
        activityComponent = appComponent.plus(new ActivityModule());
        return activityComponent;
    }

    public void releaseActivityComponent() {
        activityComponent = null;
    }

    public FragmentComponent createSettingsComponent() {
        fragmentComponent = appComponent.plus(new FragmentModule());
        return fragmentComponent;
    }

    public void releaseSettingsComponent() {
        fragmentComponent = null;
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}