package com.iambedant.instantappstarter.data.remote;

import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.data.remote.model.newsList.NewsList;
import com.iambedant.instantappstarter.data.remote.model.newsSource.NewsSources;

import io.reactivex.Observable;

/**
 * Created by @iamBedant on 12/08/17.
 */

public interface ApiHelper {

    Observable<UserResponse> doLogin(UserRequest request);
    Observable<NewsSources> loadSources();
    Observable<NewsList> loadNews(String id);
}
