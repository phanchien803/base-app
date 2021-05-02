package easy.base.viewmodel

import androidx.lifecycle.ViewModel
import easy.base.R
import easy.base.network.DomainError
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel() {

    private val _progressStateFlow = MutableStateFlow(false)

    private val _errorsFlow = MutableSharedFlow<DomainError>()

    val errorsFlow: Flow<ViewError> = _errorsFlow.asSharedFlow().map { domainError ->

        when {
            domainError is DomainError.NetworkException -> {
                ViewError.ResourceError(domainError.errorResource)
            }
            domainError.errorMessage.isEmpty() -> {
                ViewError.ResourceError(R.string.error_something_went_wrong)
            }
            else -> {
                ViewError.StringError(domainError.errorMessage)
            }
        }
    }

    val progressFlow: StateFlow<Boolean> = _progressStateFlow

    suspend fun emitError(error: DomainError) {
        _errorsFlow.emit(error)
    }

    fun emitLoadingState(isLoading: Boolean) {
        _progressStateFlow.value = isLoading
    }
}

sealed class ViewError {
    class ResourceError(val resId: Int) : ViewError()
    class StringError(val error: String) : ViewError()
}

