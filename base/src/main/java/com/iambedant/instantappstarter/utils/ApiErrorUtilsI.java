package com.iambedant.instantappstarter.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.uber.rave.RaveException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import timber.log.Timber;

/**
 * Created by @iamBedant on 14/08/17.
 */

public abstract class ApiErrorUtilsI {

    public abstract String getErrorMessage(Throwable t);
}
