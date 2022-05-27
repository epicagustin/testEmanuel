package com.emanuel.testsessionemanuel.features.login

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.emanuel.testsessionemanuel.R
import com.emanuel.testsessionemanuel.base.AlarmBroadcastReciver
import com.emanuel.testsessionemanuel.base.BaseBindingFragment
import com.emanuel.testsessionemanuel.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : BaseBindingFragment() {
    private val mBinding by lazy {
        FragmentLoginBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@LoginFragment
        }
    }
    private val mViewModel by viewModel<LoginViewModel>()
    private lateinit var navController: NavController
    override fun getViewResource() = mBinding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        if (alarmHasSet())
            goToHome()
        mBinding.viewModel = mViewModel
        setListener()
    }

    private fun setListener() {
        mBinding.onClickLogin = View.OnClickListener {
            setAlarm()
            mViewModel.getUser()


        }
        mViewModel.changeFields.observe(viewLifecycleOwner) { updatedFields ->
            if (updatedFields) {
                mViewModel.habilitateBoton()
                mViewModel.finalizeEventChangeFields()
            }
        }
        mViewModel.userLogged.observe(viewLifecycleOwner) {
            goToHome()
        }
    }

    fun alarmHasSet(): Boolean {
        val isAlarmUp = (PendingIntent.getBroadcast(
            context, 0,
            Intent(AlarmBroadcastReciver::class.java.name),
            PendingIntent.FLAG_NO_CREATE
        ) != null)
        return isAlarmUp
    }

    private fun setAlarm() {
        val alarmManager =
            requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager?
        val intent = Intent(requireContext(), AlarmBroadcastReciver::class.java)
        intent.action = AlarmBroadcastReciver::class.java.name
        val pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, intent, 0)
        alarmManager?.set(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + 30 * 1000,
            pendingIntent
        )
    }

    fun goToHome() {
        findNavController().navigate(R.id.go_to_home)
        requireActivity().finish()
    }
}