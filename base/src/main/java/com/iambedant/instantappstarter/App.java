package com.iambedant.instantappstarter;

import android.app.Application;
import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.injection.components.DaggerAppComponent;
import com.iambedant.instantappstarter.injection.modules.AppModule;

/**
 * Created by @iamBedant on 11/08/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();

    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}