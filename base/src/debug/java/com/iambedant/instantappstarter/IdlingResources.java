package com.iambedant.instantappstarter;

import android.support.test.espresso.IdlingRegistry;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import okhttp3.OkHttpClient;

/**
 * Created by @iamBedant on 04/09/17.
 */

public abstract class IdlingResources {

    public static void registerOkHttp(OkHttpClient client) {
        IdlingRegistry.getInstance().register(OkHttp3IdlingResource.create("okhttp", client));
    }

}
