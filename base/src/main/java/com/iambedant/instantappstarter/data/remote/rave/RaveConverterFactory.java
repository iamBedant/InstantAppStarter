package com.iambedant.instantappstarter.data.remote.rave;

import com.uber.rave.Rave;
import com.uber.rave.RaveException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/**
 * Created by @iamBedant on 13/08/17.
 */

public final class RaveConverterFactory extends Converter.Factory {

   public static RaveConverterFactory create() {
        return new RaveConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type, Annotation[] annotations, Retrofit retrofit) {
        Converter<ResponseBody, ?> delegateConverter = retrofit.nextResponseBodyConverter(this, type, annotations);
        return new RaveResponseConverter(delegateConverter);
    }

    /**
     * A converter that validates responses received from the network using rave.
     */
    private static final class RaveResponseConverter implements Converter<ResponseBody, Object> {

        private final Converter<ResponseBody, ?> delegateConverter;

        RaveResponseConverter(Converter<ResponseBody, ?> delegateConverter) {
            this.delegateConverter = delegateConverter;
        }

        @Override
        public Object convert(ResponseBody value) throws IOException {
            Object convert = delegateConverter.convert(value);
            try {
                Rave.getInstance().validate(convert);
            } catch (RaveException e) {
                // This response didn't pass RAVE validation, throw an exception.
                throw new RuntimeException(e);
            }
            return convert;
        }
    }
}