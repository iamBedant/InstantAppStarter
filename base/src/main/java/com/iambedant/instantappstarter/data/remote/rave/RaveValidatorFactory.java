package com.iambedant.instantappstarter.data.remote.rave;

import android.support.annotation.NonNull;

import com.uber.rave.ValidatorFactory;
import com.uber.rave.BaseValidator;
/**
 * Created by @iamBedant on 13/08/17.
 */

public class RaveValidatorFactory implements ValidatorFactory {
    @NonNull
    @Override
    public BaseValidator generateValidator() {
        return new RaveValidatorFactory_Generated_Validator();
    }
}
