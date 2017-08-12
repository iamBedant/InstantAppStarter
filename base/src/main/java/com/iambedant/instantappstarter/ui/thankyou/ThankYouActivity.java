package com.iambedant.instantappstarter.ui.thankyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.iambedant.instantappstarter.R;
import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.ui.commonBase.BaseCommonActivity;
import com.uber.rave.RaveException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ThankYouActivity extends BaseCommonActivity {


    @Inject
    DataManager mDatamanager;
    CompositeDisposable mDisposable;
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_thank_you);
        mTv = findViewById(R.id.tv);
        mDatamanager.setCurrentUserId("BBBBBB");
        mTv.setText(mDatamanager.getCurrentUserId());

    }
}
