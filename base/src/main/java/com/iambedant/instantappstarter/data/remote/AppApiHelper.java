package com.iambedant.instantappstarter.data.remote;

import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.data.remote.rave.RaveConverterFactory;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper{

    private static String BASE_URL = "http://demo7502315.mockable.io/";

    @Inject
    public AppApiHelper() {

    }

    public interface ApiClient {
        @POST("login")
        Observable<UserResponse> getResults();
    }

    private ApiClient getApiClient(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(RaveConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ApiClient.class);
    }

    @Override
    public Observable<UserResponse> doLogin(UserRequest request) {
        return getApiClient().getResults();
    }
}
