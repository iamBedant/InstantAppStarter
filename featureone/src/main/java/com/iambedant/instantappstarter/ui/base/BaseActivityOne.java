package com.iambedant.instantappstarter.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.iambedant.instantappstarter.App;
import com.iambedant.instantappstarter.injection.ActivityComponentOne;
import com.iambedant.instantappstarter.injection.ActivityModuleOne;
import com.iambedant.instantappstarter.injection.DaggerActivityComponentOne;

/**
 * Created by @iamBedant on 12/08/17.
 */

public class BaseActivityOne extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public ActivityComponentOne giveActivityComponent() {
        return DaggerActivityComponentOne.builder()
                .activityModuleOne(new ActivityModuleOne())
                .appComponent(((App) getApplication()).getAppComponent())
                .build();
    }
}
