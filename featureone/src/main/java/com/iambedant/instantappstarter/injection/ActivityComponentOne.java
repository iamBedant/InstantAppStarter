package com.iambedant.instantappstarter.injection;

import com.iambedant.instantappstarter.injection.components.AppComponent;
import com.iambedant.instantappstarter.ui.newsSources.NewsSourceActivity;
import com.iambedant.instantappstarter.ui.thankyou.ThankYouActivity;

import dagger.Component;

/**
 * Created by @iamBedant on 12/08/17.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModuleOne.class)
public interface ActivityComponentOne {
    void inject(NewsSourceActivity activity);
}
