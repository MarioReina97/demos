package it.marioreina.demoviews.credits

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

class CreditsFragment: BaseComposeFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //TODO fix click and font recognition
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DemoAndroidNativeTheme {
                    CreditsScreen()
                }
            }
        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.txtMessage.movementMethod = LinkMovementMethod.getInstance()
//        binding.txtMessage.setLinkTextColor(getColor(requireContext(), R.color.main_500))
//        binding.txtMessage.text = getString(R.string.credits_message).convertFromHtml()
//    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.credits_title))
        (requireActivity() as HomeActivity).showBottomNavBar()
    }
}