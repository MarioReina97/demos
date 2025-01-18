package it.marioreina.demoviews.firstaccess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import it.marioreina.demoviews.R
import it.marioreina.demoviews.databinding.DialogFirstAccessBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstAccessDialog: DialogFragment() {

    private val viewModel: FirstAccessViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        setStyle(STYLE_NO_FRAME, R.style.BaseDialog_FullScreenDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_first_access, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DialogFirstAccessBinding.bind(view)
        initViews(binding)
    }


    private fun initViews(binding: DialogFirstAccessBinding) {
        binding.imgClose.setOnClickListener {
            viewModel.setFirstAccessDone()
            dismissNow()
        }
    }


}