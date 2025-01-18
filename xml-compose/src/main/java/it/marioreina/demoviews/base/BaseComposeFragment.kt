package it.marioreina.demoviews.base

import androidx.fragment.app.Fragment

open class BaseComposeFragment(): Fragment() {

    fun setToolbarTitle(title: String) {
        getBaseActivity().setToolbarTitle(title)
    }

    fun setBackButton(resourceHomeAsUpIndicator: Int?) {
        getBaseActivity().setBackButton(resourceHomeAsUpIndicator)
    }

    fun onError(error: Throwable) {
        getBaseActivity().onError(error)
    }

    fun getBaseActivity(): BaseActivity {
        return requireActivity() as BaseActivity
    }
}