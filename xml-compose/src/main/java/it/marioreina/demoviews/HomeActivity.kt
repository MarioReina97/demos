package it.marioreina.demoviews

import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.weredev.binding_ui.viewBinding
import it.marioreina.demoviews.base.BaseActivity
import it.marioreina.demoviews.databinding.ActivityHomeBinding

class HomeActivity: BaseActivity() {

    private val binding: ActivityHomeBinding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initToolbar(binding.toolbarLayout.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_deals, R.id.nav_wishlist, R.id.nav_credits
            )
        )
        setupWithNavController(binding.toolbarLayout.toolbar, navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun getToolbarTitleView(): TextView {
        return binding.toolbarLayout.txtTitle
    }

    fun showBottomNavBar() {
        binding.navView.isVisible = true
    }

    fun hideBottomNavBar() {
        binding.navView.isVisible = false
    }

}