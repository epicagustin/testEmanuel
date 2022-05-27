package com.emanuel.testsessionemanuel.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.emanuel.testsessionemanuel.util.EMPTY


abstract class BaseFragment : Fragment() {

    protected abstract fun getViewIdResource(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (getViewIdResource() != -1)
            inflater.inflate(getViewIdResource(), container, false)
        else
            null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    open fun showLoading(show: Boolean) {
        (activity as BaseActivity).showLoading(show)
    }

    open fun showMessage(@StringRes message: Int) {
        alertMessage(getString(message))
    }

    open fun showMessage(message: String,btnText:String = String.EMPTY) {
        alertMessage(message,btnText)
    }

    private fun alertMessage(message: String,btnText:String = String.EMPTY ,onClickOk: (() -> Unit)? = null) {
        (activity as BaseActivity).alertMessage(message,btnText ,onClickOk)
    }

    open fun showMessageByException(
        exception: Exception, onClickOkDialog: (() -> Unit)? = null, onClickOkStoreNotAvailable: (() -> Unit)? = null,
        onClickOkOther: (() -> Unit)? = null
    ) {
        (activity as BaseActivity).showMessageByException(exception, onClickOkDialog, onClickOkStoreNotAvailable, onClickOkOther)
    }
}