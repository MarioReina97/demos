package it.marioreina.demoviews.base

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.weredev.usecase.utils.ResponseInterface

abstract class BaseActivity: AppCompatActivity(), ResponseInterface {

    fun initToolbar(
        toolbar: Toolbar,
        resourceHomeAsUpIndicator: Int? = 0
    ) {
        this.setSupportActionBar(toolbar)
        setBackButton(resourceHomeAsUpIndicator)
    }

    fun setToolbarTitle(title: String) {
        getToolbarTitleView().text = title
    }

    abstract fun getToolbarTitleView(): TextView

    fun setBackButton(resourceHomeAsUpIndicator: Int?) {
        this.supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            if (resourceHomeAsUpIndicator != null && resourceHomeAsUpIndicator != 0) {
                setHomeAsUpIndicator(resourceHomeAsUpIndicator)
                setDisplayHomeAsUpEnabled(true)
            } else {
                setDisplayHomeAsUpEnabled(false)
            }
        }
    }


    override fun onError(error: Throwable) {
        error.printStackTrace()
    }

    override fun onLoading(isLoading: Boolean) {

    }
}