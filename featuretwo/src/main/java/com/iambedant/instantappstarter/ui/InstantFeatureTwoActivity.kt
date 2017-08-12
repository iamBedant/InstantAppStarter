package com.iambedant.instantappstarter.ui

import android.os.Bundle
import android.util.Log
import com.iambedant.instantappstarter.data.DataManager
import com.iambedant.instantappstarter.data.remote.model.UserRequest
import com.iambedant.instantappstarter.data.remote.model.UserResponse
import com.iambedant.instantappstarter.featuretwo.R
import com.iambedant.instantappstarter.ui.base.BaseActivityTwo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import com.uber.rave.RaveException
import io.reactivex.functions.Consumer


class InstantFeatureTwoActivity : BaseActivityTwo() {

    @Inject
    lateinit var mDatamanager: DataManager

    @Inject
    lateinit var mDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_instant_feature_two)
        var request = UserRequest()


        mDisposable.add(mDatamanager.doLogin(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { userResponse -> Log.d("TTAAGGSS", userResponse.aadharReturnCode) },
                        { throwable ->
                            val cause = throwable.cause
                            if (cause is RaveException) {
                                Log.d("HELLO", "Call did not pass RAVE validation: " + cause.message)
                            } else if (cause != null) {
                                Log.d("HELLO", "Call failed for unknown reason: " + cause.message)
                            }
                        }))

    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
