package com.iambedant.instantappstarter;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.injection.components.DaggerAppComponent;
import com.iambedant.instantappstarter.injection.modules.AppModule;

/**
 * Created by @iamBedant on 11/08/17.
 */

public abstract class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
        MultiDex.install(this);
        init();
    }

    public abstract void init();


    public AppComponent getAppComponent() {
        return appComponent;
    }


    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}