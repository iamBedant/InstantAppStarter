package com.iambedant.instantappstarter.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.iambedant.instantappstarter.App;
import com.iambedant.instantappstarter.injection.ActivityComponentTwo;
import com.iambedant.instantappstarter.injection.ActivityModuleTwo;
import com.iambedant.instantappstarter.injection.DaggerActivityComponentTwo;

/**
 * Created by @iamBedant on 12/08/17.
 */

public class BaseActivityTwo extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public ActivityComponentTwo giveActivityComponent() {
        return DaggerActivityComponentTwo.builder()
                .activityModuleTwo(new ActivityModuleTwo())
                .appComponent(((App) getApplication()).getAppComponent())
                .build();
    }
}
