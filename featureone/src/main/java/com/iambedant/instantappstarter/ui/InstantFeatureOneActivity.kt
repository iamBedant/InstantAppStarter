package com.iambedant.instantappstarter.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.iambedant.instantappstarter.R
import com.iambedant.instantappstarter.data.DataManager
import com.iambedant.instantappstarter.ui.base.BaseActivityOne
import javax.inject.Inject

class InstantFeatureOneActivity : BaseActivityOne() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)

        setContentView(R.layout.activity_instant_feature_one)
    }
}
