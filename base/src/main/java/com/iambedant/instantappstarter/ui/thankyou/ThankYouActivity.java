package com.iambedant.instantappstarter.ui.thankyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.iambedant.instantappstarter.R;
import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.ui.commonBase.BaseCommonActivity;

import javax.inject.Inject;

public class ThankYouActivity extends BaseCommonActivity {


    @Inject
    DataManager mDatamanager;
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
