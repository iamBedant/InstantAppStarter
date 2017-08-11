package com.iambedant.instantappstarter;

import android.app.Application;
import com.iambedant.instantappstarter.injection.component.ApplicationComponent;
import com.iambedant.instantappstarter.injection.component.DaggerApplicationComponent;

/**
 * Created by @iamBedant on 11/08/17.
 */

public class MyApp extends Application {

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();
    }
}
