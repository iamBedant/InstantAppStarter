package com.iambedant.instantappstarter.ui.featureOneBase

import android.os.Bundle
import com.iambedant.instantappstarter.App
import com.iambedant.instantappstarter.injection.components.ActivityComponent
import com.iambedant.instantappstarter.ui.base.BaseActivity

/**
 * Created by @iamBedant on 12/08/17.
 */
open class BaseFeatureOneActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun getActivityComponent(): ActivityComponent {
        return (application as App).createActivityComponent()
    }
}