package com.iambedant.instantappstarter.data.remote;

import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;

import io.reactivex.Observable;

/**
 * Created by @iamBedant on 12/08/17.
 */

public interface ApiHelper {

    Observable<UserResponse> doLogin(UserRequest request);
}
