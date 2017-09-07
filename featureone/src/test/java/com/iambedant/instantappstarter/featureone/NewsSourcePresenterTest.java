package com.iambedant.instantappstarter.featureone;

import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.data.remote.model.newsSource.NewsSources;
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source;
import com.iambedant.instantappstarter.ui.newsSources.NewsSourceMvpView;
import com.iambedant.instantappstarter.ui.newsSources.NewsSourcePresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by @iamBedant on 07/09/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class NewsSourcePresenterTest {

    @Mock
    NewsSourceMvpView mockMvpView;

    @Mock
    DataManager mockDdataManager;

    private NewsSourcePresenter<NewsSourceMvpView> mockMvpPresenter;

    @BeforeClass
    public static void onlyOnce() throws Exception {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {
                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable)
                            throws Exception {
                        return Schedulers.trampoline();
                    }
                });
    }



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mockMvpPresenter = new NewsSourcePresenter<>(mockDdataManager, compositeDisposable);
        mockMvpPresenter.onAttach(mockMvpView);
    }

    @Test
    public void successfullyFetchDataAndUpdateUI() throws Exception {
        NewsSources newsSources = new NewsSources();
        List<Source> list = new ArrayList<>();
        newsSources.setSources(list);

        doReturn(Observable.just(newsSources))
                .when(mockDdataManager)
                .loadSources();

//        when(mockDdataManager.loadSources()).thenReturn(Observable.just(newsSources));
        mockMvpPresenter.loadNewsSource();
        verify(mockMvpView).showLoading();
        verify(mockMvpView).hideLoading();
        verify(mockMvpView).updateViewModel(newsSources.getSources());

    }

    @After
    public void tearDown(){
        mockMvpPresenter.onDetach();
        RxAndroidPlugins.reset();
    }
}
