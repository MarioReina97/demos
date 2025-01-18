package it.marioreina.demoviews.firstaccess

import com.weredev.usecase.BaseViewModel
import it.marioreina.demoviews.domain.usecase.SetFirstAccessDoneUseCase

class FirstAccessViewModel(
    private val setFirstAccessDoneUseCase: SetFirstAccessDoneUseCase
): BaseViewModel() {

    fun setFirstAccessDone() {
        setFirstAccessDoneUseCase.invoke()
    }
}