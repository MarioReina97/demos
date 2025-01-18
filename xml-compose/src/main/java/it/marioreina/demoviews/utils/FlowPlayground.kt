package it.marioreina.demoviews.utils

import com.weredev.usecase.BaseAsyncUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//TODO: push to weredev
object FlowPlayground {

    fun <Y, Params> BaseAsyncUseCase<Y, Params>.executeAndDispose(
        coroutineScope: CoroutineScope,
        onSuccess: (Y) -> Unit = {},
        onLoading: (Boolean) -> Unit = {},
        onError: (Throwable) -> Unit = {},
        params: Params? = null
    ) {
        coroutineScope.launch {
            onLoading(true)
            println("executeAndDispose loading")
            val scope = Dispatchers.IO
            withContext(scope) {
                flow {
                    emit(this@executeAndDispose.invoke(params))
                }
                .catch {
                    println("executeAndDispose error")
                    onLoading(false)
                    onError(it)
                    scope.cancel()
                }
                .collect {
                    println("executeAndDispose success")
                    onLoading(false)
                    onSuccess(it)
                    scope.cancel()
                }
            }
        }
    }
}