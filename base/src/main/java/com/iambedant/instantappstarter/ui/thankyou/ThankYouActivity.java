package com.iambedant.instantappstarter.ui.thankyou;

import android.os.Bundle;
import android.widget.Toast;

import com.iambedant.instantappstarter.R;
import com.iambedant.instantappstarter.ui.commonBase.BaseCommonActivity;

import javax.inject.Inject;

public class ThankYouActivity extends BaseCommonActivity implements ThankYouMvpView{


    @Inject
    ThankyouMvpPresenter<ThankYouMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_thank_you);
        mPresenter.onAttach(this);
        mPresenter.onHomeClicked();
    }

    @Override
    public void openHomeActivity() {
        Toast.makeText(ThankYouActivity.this,"This Worked",Toast.LENGTH_SHORT).show();
    }
}
