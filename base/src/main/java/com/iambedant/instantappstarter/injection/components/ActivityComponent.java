package com.iambedant.instantappstarter.injection.components;

import com.iambedant.instantappstarter.injection.PerActivity;
import com.iambedant.instantappstarter.injection.modules.ActivityModule;
import com.iambedant.instantappstarter.ui.thankyou.ThankYouActivity;

import dagger.Subcomponent;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(ThankYouActivity activity);
}
