package com.iambedant.instantappstarter.ui

import android.os.Bundle
import com.iambedant.instantappstarter.featuretwo.R
import com.iambedant.instantappstarter.ui.base.BaseActivityTwo


class InstantFeatureTwoActivity : BaseActivityTwo() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_instant_feature_two)


    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
