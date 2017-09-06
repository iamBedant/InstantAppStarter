package com.iambedant.instantappstarter.injection;


import com.iambedant.instantappstarter.ui.newsSources.NewsSourceMvpPresenter;
import com.iambedant.instantappstarter.ui.newsSources.NewsSourceMvpView;
import com.iambedant.instantappstarter.ui.newsSources.NewsSourcePresenter;
import com.iambedant.instantappstarter.ui.thankyou.ThankYouMvpView;
import com.iambedant.instantappstarter.ui.thankyou.ThankYouPresenter;
import com.iambedant.instantappstarter.ui.thankyou.ThankyouMvpPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Module
public class ActivityModuleOne {

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    NewsSourceMvpPresenter<NewsSourceMvpView> provideNewsSourcePresenter(NewsSourcePresenter<NewsSourceMvpView> presenter){
        return presenter;
    }
}
