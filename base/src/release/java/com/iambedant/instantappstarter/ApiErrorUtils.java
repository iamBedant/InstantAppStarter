package com.iambedant.instantappstarter;

import com.iambedant.instantappstarter.utils.ApiErrorUtilsI;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.uber.rave.RaveException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import timber.log.Timber;

/**
 * Created by @iamBedant on 14/08/17.
 */

public class ApiErrorUtils extends ApiErrorUtilsI {

    @Override
    public  String getErrorMessage(Throwable t) {
        String errorMessage = "OOPs!! Something went wrong";

        Timber.d(t);

        if (t instanceof HttpException) {
            switch (((HttpException) t).code()){
                case 500:
                    errorMessage = "Server Down Customize message";
                    break;
                case 400:
                    errorMessage= "Bad Request Customize Message";
                    break;
                default:
                    break;

            }
        } else if (t instanceof SocketTimeoutException) {
            errorMessage = "Slow Network Connection";
        } else if (t instanceof IOException) {
            errorMessage = "Network Gone Down";
        }

        Throwable cause = t.getCause();
        if (cause instanceof RaveException) {
            errorMessage = "OOPs!! Something went wrong";
        }

        return errorMessage;
    }
}
