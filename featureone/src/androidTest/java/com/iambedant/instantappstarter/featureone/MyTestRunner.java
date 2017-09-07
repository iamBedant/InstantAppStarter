package com.iambedant.instantappstarter.featureone;

import android.support.test.runner.AndroidJUnitRunner;

import com.squareup.rx2.idler.Rx2Idler;

import io.reactivex.plugins.RxJavaPlugins;

/**
 * Created by @iamBedant on 05/09/17.
 */

public final class MyTestRunner extends AndroidJUnitRunner {
    @Override
    public void onStart() {
        RxJavaPlugins.setInitComputationSchedulerHandler(Rx2Idler.create("RxJava 2.x Computation Scheduler"));
        super.onStart();
    }
}