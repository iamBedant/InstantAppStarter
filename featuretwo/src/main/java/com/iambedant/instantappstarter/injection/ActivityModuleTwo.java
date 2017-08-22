package com.iambedant.instantappstarter.injection;


import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpPresenter;
import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpView;
import com.iambedant.instantappstarter.ui.newsSources.NewsListPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 12/08/17.
 */

@Module
public class ActivityModuleTwo {
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    NewsListMvpPresenter<NewsListMvpView> provideNewsSourcePresenter(NewsListPresenter<NewsListMvpView> presenter){
        return presenter;
    }
}
