package com.emanuel.testsessionemanuel.base

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.emanuel.testsessionemanuel.AlertDialogFragment
import com.emanuel.testsessionemanuel.R
import com.emanuel.testsessionemanuel.util.EMPTY

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getViewIdResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getViewIdResource() != -1)
            setContentView(getViewIdResource())
    }

    open fun showMessage(message: String) {
        alertMessage(message)
    }

    open fun showMessage(@StringRes message: Int) {
        alertMessage(getString(message))
    }

    open fun alertMessage(
        message: String,
        textBtn: String = String.EMPTY,
        onClickOk: (() -> Unit)? = null
    ) {
        val errorDialog = AlertDialogFragment.newInstance()
        errorDialog.onClickBtnOk = onClickOk
        errorDialog.subtitle = message
        errorDialog.btnOkText = textBtn
        try {
            errorDialog.show(supportFragmentManager, errorDialog.tag)
        } catch (ex: Exception) {
        }
    }

    open fun showMessageByException(
        exception: Exception,
        onClickOkDialog: (() -> Unit)? = null,
        onClickOkStoreNotAvailable: (() -> Unit)? = null,
        onClickOkOther: (() -> Unit)? = null
    ) {
        /* when (exception) {

              is UnknownHostException -> {
                 ErrorNetworkConnectionDialog.newInstance {
                     onClickOkDialog?.invoke()
                 }.showDialog(supportFragmentManager)
             }
             is ServiceErrorException, is SocketTimeoutException, is ConnectException -> {
                 GenericErrorDialog.newInstance(
                     onClickOkButton = {
                         if (onClickOkOther == null)
                             onBackPressed()
                         else
                             onClickOkOther.invoke()
                     }
                 ).showDialog(supportFragmentManager)
             }
             is NotFoundException -> {
                 ErrorServerDialog.newInstance {
                     if (onClickOkOther == null)
                         onBackPressed()
                     else
                         onClickOkOther.invoke()
                 }.showDialog(supportFragmentManager)
             }
             is StoreNotAvailableException -> {
                 StoreNotAvailableDialog.newInstance(applicationContext) {
                     if (onClickOkStoreNotAvailable == null)
                         finish()
                     else
                         onClickOkStoreNotAvailable.invoke()
                 }
             }
             is ErrorLogicServerException -> {
                 GenericErrorDialog.newInstance(
                     errorMessage = exception.message,
                     onClickOkButton = {}
                 ).showDialog(supportFragmentManager)
             }

             is UnauthorizedException -> {
                 UnauthorizedDialog.newInstance().showDialog(supportFragmentManager)
             }

             else -> Log.d("ShowMessageByException", "$exception")
        }*/
    }

    @SuppressLint("ResourceType")
    open fun showLoading(show: Boolean) {
        findViewById<FrameLayout>(R.id.loading)?.visibility =
            if (show) View.VISIBLE else View.GONE
    }

    open fun hideKeyboard(view: View?) {
        try {
            val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view!!.windowToken, 0)
        } catch (e: Exception) {
            Log.d("BaseActivity", "hideKeyboard: ", e)
        }
    }

}
