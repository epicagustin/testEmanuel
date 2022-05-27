package com.emanuel.testsessionemanuel.features.login

import android.os.Bundle
import android.view.View
import com.emanuel.testsessionemanuel.base.BaseBindingActivity
import com.emanuel.testsessionemanuel.databinding.ActivityLoginBinding

//@AndroidEntryPoint
class LoginActivity : BaseBindingActivity() {
    private val mBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater).apply { lifecycleOwner = this@LoginActivity }
    }

    override fun getViewResource(): View = mBinding.root
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}