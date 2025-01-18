package it.marioreina.demoviews.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.weredev.usecase.utils.ResponseInterface

open class BaseFragment(@LayoutRes contentLayoutId: Int): Fragment(contentLayoutId), ResponseInterface {

    override fun onError(error: Throwable) {
        getBaseActivity().onError(error)
    }

    override fun onLoading(isLoading: Boolean) {
        getBaseActivity().onLoading(isLoading)
    }

    fun setToolbarTitle(title: String) {
        getBaseActivity().setToolbarTitle(title)
    }

    fun setBackButton(resourceHomeAsUpIndicator: Int?) {
        getBaseActivity().setBackButton(resourceHomeAsUpIndicator)
    }

    fun getBaseActivity(): BaseActivity {
        return requireActivity() as BaseActivity
    }
}