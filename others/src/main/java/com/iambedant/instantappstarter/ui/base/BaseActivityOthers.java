package com.iambedant.instantappstarter.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.iambedant.instantappstarter.App;
import com.iambedant.instantappstarter.injection.ActivityComponentOthers;
import com.iambedant.instantappstarter.injection.ActivityModuleOthers;
import com.iambedant.instantappstarter.injection.DaggerActivityComponentOthers;

/**
 * Created by @iamBedant on 12/08/17.
 */

public class BaseActivityOthers extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public ActivityComponentOthers giveActivityComponent() {
        return DaggerActivityComponentOthers.builder()
                .activityModuleOthers(new ActivityModuleOthers())
                .appComponent(((App) getApplication()).getAppComponent())
                .build();
    }
}
