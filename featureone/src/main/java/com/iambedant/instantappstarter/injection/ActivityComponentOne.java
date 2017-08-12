package com.iambedant.instantappstarter.injection;

import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.injection.modules.ActivityModule;
import com.iambedant.instantappstarter.ui.InstantFeatureOneActivity;
import com.iambedant.instantappstarter.ui.thankyou.ThankYouActivity;

import dagger.Component;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModuleOne.class)
public interface ActivityComponentOne {
    void inject(InstantFeatureOneActivity activity);
}
