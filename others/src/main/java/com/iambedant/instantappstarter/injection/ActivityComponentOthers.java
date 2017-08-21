package com.iambedant.instantappstarter.injection;

import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.ui.OtherActivity;

import dagger.Component;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModuleOthers.class)
public interface ActivityComponentOthers {
    void inject(OtherActivity activity);
}
