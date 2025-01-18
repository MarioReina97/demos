package it.marioreina.demoviews.domain.usecase

import com.weredev.usecase.BaseAsyncUseCase
import com.weredev.usecase.BaseSyncUseCase
import it.marioreina.demoviews.data.repository.CacheRepository

class IsFirstAccessDoneUseCase(
    private val cacheRepository: CacheRepository
): BaseAsyncUseCase<Boolean, Unit?>() {
    override suspend fun invoke(params: Unit?): Boolean {
        return cacheRepository.isFirstAccessDone()
    }
}