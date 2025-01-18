package it.marioreina.demoviews.deal

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import coil.load
import com.weredev.binding_ui.viewBinding
import com.weredev.usecase.observeWithResource
import it.marioreina.demoviews.HomeActivity
import it.marioreina.demoviews.R
import it.marioreina.demoviews.base.BaseFragment
import it.marioreina.demoviews.databinding.FragmentDealDetailBinding
import it.marioreina.demoviews.domain.entity.DealDetailEntity
import it.marioreina.demoviews.utils.CheapShark
import it.marioreina.demoviews.utils.DealConst
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DealDetailFragment: BaseFragment(R.layout.fragment_deal_detail) {

    private val binding by viewBinding(FragmentDealDetailBinding::bind)

    private val dealViewModel: DealViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dealId = arguments?.getString(DealConst.ARGS_DEAL_ID)
        if(dealId.isNullOrBlank()) {
            requireActivity().onBackPressed()
        }
        else
        {
            initObserver(dealId)
            initView()
            dealViewModel.getDealDetail(dealId)
        }
    }

    private fun initObserver(dealId: String) {
        dealViewModel.dealDetailEntityLiveData.observeWithResource(this) {
            if(it != null) {
                prepareDealView(it, dealId)
            }
        }
    }

    private fun prepareDealView(dealDetailEntity: DealDetailEntity, dealId: String) {
        val gameInfo = dealDetailEntity.gameInfo
        //GAME Info
        setToolbarTitle(gameInfo?.name ?: "")
        binding.imgIcon.load(gameInfo?.thumb ?: "") {
            listener(
                onStart = { binding.progressBarLoader.isVisible = true },
                onSuccess = { _ , _ ->
                    binding.progressBarLoader.isVisible = false
                }
            )
        }
        binding.txtTitle.text = gameInfo?.name ?: ""
        binding.txtReleaseDate.text = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date(gameInfo?.releaseDate ?: 0))

        binding.txtDiscountPrice.text = String.format("%s$", gameInfo?.salePrice ?: "")
        binding.txtOriginalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        binding.txtOriginalPrice.text = String.format("%s$", gameInfo?.retailPrice ?: "")
        binding.txtSteam.text = String.format("%s - %s(%s)", gameInfo?.steamRatingText, gameInfo?.steamRatingPercent, gameInfo?.steamRatingCount)

        binding.txtMetacritics.text = gameInfo?.metacriticScore
        binding.txtMetacritics.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding.txtMetacritics.setOnClickListener {
            goToWebSite(String.format("%s%s", DealConst.BASE_LINK_METACRITICS, gameInfo?.metacriticLink ?: ""))
        }
        binding.btDeal.setOnClickListener {
            goToWebSite(String.format("%s%s", CheapShark.BASE_LINK_CHEAP_SHARK, dealId))
        }
    }

    private fun goToWebSite(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun initView() {
        (requireActivity() as HomeActivity).hideBottomNavBar()
        setBackButton(R.drawable.ic_back)
        setToolbarTitle("")
    }

    override fun onPause() {
        super.onPause()
        dealViewModel.dealDetailEntityLiveData.value = null
    }
}