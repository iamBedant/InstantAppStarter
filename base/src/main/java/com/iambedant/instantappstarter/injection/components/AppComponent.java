package com.iambedant.instantappstarter.injection.components;

/**
 * Created by @iamBedant on 12/08/17.
 */

import com.iambedant.instantappstarter.App;
import com.iambedant.instantappstarter.injection.modules.ActivityModule;
import com.iambedant.instantappstarter.injection.modules.AppModule;
import com.iambedant.instantappstarter.injection.modules.FragmentModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    ActivityComponent plus(ActivityModule activityModule);

    FragmentComponent plus(FragmentModule fragmentModule);


}