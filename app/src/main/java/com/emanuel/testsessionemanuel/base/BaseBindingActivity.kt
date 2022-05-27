package com.emanuel.testsessionemanuel.base

import android.os.Bundle
import android.view.View

abstract class BaseBindingActivity : BaseActivity() {

    protected abstract fun getViewResource(): View
    override fun getViewIdResource() = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewResource())
    }
}
