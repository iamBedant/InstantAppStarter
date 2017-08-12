package com.iambedant.instantappstarter.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.iambedant.instantappstarter.injection.ActivityContext;
import com.iambedant.instantappstarter.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Module
public class ActivityModule {

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
