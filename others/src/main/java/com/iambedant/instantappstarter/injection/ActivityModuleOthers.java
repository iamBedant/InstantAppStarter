package com.iambedant.instantappstarter.injection;


import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Module
public class ActivityModuleOthers {
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
