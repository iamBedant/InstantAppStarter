package com.iambedant.instantappstarter.injection;

import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.ui.InstantFeatureTwoActivity;

import dagger.Component;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModuleTwo.class)
public interface ActivityComponentTwo {
    void inject(InstantFeatureTwoActivity activity);
}
