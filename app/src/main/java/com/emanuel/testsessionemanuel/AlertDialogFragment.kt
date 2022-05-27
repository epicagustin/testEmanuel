package com.emanuel.testsessionemanuel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.emanuel.testsessionemanuel.base.BaseDialogFragment
import com.emanuel.testsessionemanuel.databinding.FragmentDialogAlertBinding
import com.emanuel.testsessionemanuel.util.EMPTY

class AlertDialogFragment : BaseDialogFragment() {

    companion object {
        fun newInstance() =
            AlertDialogFragment()
    }

    var title = String.EMPTY
    var subtitle = String.EMPTY
    var btnOkText = String.EMPTY
    var onClickBtnOk: (() -> Unit)? = null

    private lateinit var binding: FragmentDialogAlertBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_alert, container, false)
        return binding.root
    }

    private fun onClickBtnOk() {
        binding.onClickOk = View.OnClickListener {
            onClickBtnOk?.invoke() ?: kotlin.run { dismiss() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title = title
        binding.subtitle = subtitle
        binding.btnOkText = btnOkText
        onClickBtnOk()
    }
}