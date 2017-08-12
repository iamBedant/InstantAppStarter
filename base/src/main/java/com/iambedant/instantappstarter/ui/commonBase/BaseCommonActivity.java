package com.iambedant.instantappstarter.ui.commonBase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.iambedant.instantappstarter.App;
import com.iambedant.instantappstarter.injection.components.ActivityComponent;
import com.iambedant.instantappstarter.ui.base.BaseActivity;

/**
 * Created by @iamBedant on 12/08/17.
 */

public abstract class BaseCommonActivity extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public ActivityComponent getActivityComponent() {
        return ((App) getApplication()).createActivityComponent();
    }
}
