package it.marioreina.demoviews.deal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import it.marioreina.demoviews.HomeActivity
import it.marioreina.demoviews.R
import it.marioreina.demoviews.base.BaseComposeFragment
import it.marioreina.demoviews.ui.DemoAndroidNativeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class DealFragment : BaseComposeFragment() {

    private val dealViewModel: DealViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            dealViewModel.isFirstAccess()
            dealViewModel.getDeals()
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DemoAndroidNativeTheme {
                    DealScreen(
                        dealState = dealViewModel.dealState.value,
                        onError = {
                            onError(it)
                        }
                    )
                }
            }
        }
        //TODO implement side effect for error
        //TODO implement key in grid
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.deals))
        (requireActivity() as HomeActivity).showBottomNavBar()
    }
}