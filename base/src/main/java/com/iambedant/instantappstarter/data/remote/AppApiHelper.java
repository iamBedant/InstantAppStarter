package com.iambedant.instantappstarter.data.remote;

import com.iambedant.instantappstarter.BuildConfig;
import com.iambedant.instantappstarter.IdlingResources;
import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.data.remote.model.newsList.NewsList;
import com.iambedant.instantappstarter.data.remote.model.newsSource.NewsSources;
import com.iambedant.instantappstarter.data.remote.rave.RaveConverterFactory;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {


    @Inject
    public AppApiHelper() {

    }

    public interface ApiClient {
        @POST("login")
        Observable<UserResponse> getResults();

        @GET("sources")
        Observable<NewsSources> getSources();

        @GET("articles")
        Observable<NewsList> getNews(@Query("source") String id, @Query("apiKey") String key);
    }

    private ApiClient getApiClient() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);

        OkHttpClient myClient = client.build();

        if (BuildConfig.DEBUG) {
            IdlingResources.registerOkHttp(myClient);
        }

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(myClient)
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

    @Override
    public Observable<NewsSources> loadSources() {
        return getApiClient().getSources();
    }

    @Override
    public Observable<NewsList> loadNews(String id) {
        return getApiClient().getNews(id, BuildConfig.PASSWORD);
    }
}
