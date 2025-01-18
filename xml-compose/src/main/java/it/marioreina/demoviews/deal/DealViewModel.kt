package it.marioreina.demoviews.deal

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.weredev.usecase.BaseViewModel
import com.weredev.usecase.utils.Resource
import it.marioreina.demoviews.domain.entity.DealDetailEntity
import it.marioreina.demoviews.domain.usecase.GetDealDetailUseCase
import it.marioreina.demoviews.domain.usecase.GetDealsUseCase
import it.marioreina.demoviews.domain.usecase.IsFirstAccessDoneUseCase
import it.marioreina.demoviews.utils.FlowPlayground.executeAndDispose

class DealViewModel(
    private val getDealsUseCase: GetDealsUseCase,
    private val getDealDetailUseCase: GetDealDetailUseCase,
    private val isFirstAccessDoneUseCase: IsFirstAccessDoneUseCase,
): BaseViewModel() {
    val dealDetailEntityLiveData: MutableLiveData<Resource<DealDetailEntity?>> = MutableLiveData()

    private val _dealState: MutableState<DealState> = mutableStateOf(DealState())
    val dealState: State<DealState> = _dealState

    fun getDeals() {
        getDealsUseCase.executeAndDispose(
            coroutineScope = viewModelScope,
            onSuccess = {
                _dealState.value = _dealState.value.copy(dealList = it, isLoading = false)
            },
            onLoading = {
                _dealState.value = _dealState.value.copy(isLoading = true)
            },
            onError = {
                _dealState.value = _dealState.value.copy(isLoading = false)
            },
        )
    }

    fun getDealDetail(dealId: String) {
        getDealDetailUseCase.executeAndDispose(dealDetailEntityLiveData, dealId)
    }

    fun isFirstAccess() {
        isFirstAccessDoneUseCase.executeAndDispose(
            coroutineScope = viewModelScope,
            onSuccess = {
                _dealState.value = _dealState.value.copy(isFirstAccess = it)
            }
        )
    }
}