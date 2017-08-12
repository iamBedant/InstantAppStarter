package com.iambedant.instantappstarter.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Singleton
public final class SingletonUtil {

    @Inject
    SingletonUtil() {

    }

    public String doSomething() {
        return "SingletonUtil: " + hashCode();
    }
}