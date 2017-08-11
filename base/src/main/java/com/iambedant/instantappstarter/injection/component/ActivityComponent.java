package com.iambedant.instantappstarter.injection.component;

import android.app.Activity;

import com.iambedant.instantappstarter.injection.PerActivity;
import com.iambedant.instantappstarter.injection.module.ActivityModule;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by @iamBedant on 09/07/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {



    @Component.Builder
    interface Builder {
        ActivityComponent build();
        Builder appComponent(ApplicationComponent appComponent);

        @BindsInstance
        Builder activity(Activity activity);
    }

}