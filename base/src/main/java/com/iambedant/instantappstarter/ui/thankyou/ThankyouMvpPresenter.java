
package com.iambedant.instantappstarter.ui.thankyou;

import com.iambedant.instantappstarter.injection.PerActivity;
import com.iambedant.instantappstarter.ui.base.MvpPresenter;

@PerActivity
public interface ThankyouMvpPresenter<V extends ThankYouMvpView> extends MvpPresenter<V> {

  void onHomeClicked();

}
