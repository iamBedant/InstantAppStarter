package com.iambedant.instantappstarter.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iambedant.instantappstarter.R
import com.iambedant.instantappstarter.ui.featureOneBase.BaseFeatureOneActivity

class InstantFeatureOneActivity : BaseFeatureOneActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getActivityComponent().inject(this)
        setContentView(R.layout.activity_instant_feature_one)
    }
}
