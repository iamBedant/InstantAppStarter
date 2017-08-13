package com.iambedant.instantappstarter;

import timber.log.Timber;

/**
 * Created by @iamBedant on 13/08/17.
 */

public class AppImpl extends App{

    @Override
    public void init() {
        Timber.plant(new ReleaseTree());
    }
}
