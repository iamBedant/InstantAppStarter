package com.iambedant.instantappstarter.injection.component;

import android.app.Application;

import com.iambedant.instantappstarter.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by @iamBedant on 11/08/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        ApplicationComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
