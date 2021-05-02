package easy.app.base.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Leasy/app/base/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_errorsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Leasy/app/base/network/DomainError;", "_progressStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "errorsFlow", "Lkotlinx/coroutines/flow/Flow;", "Leasy/app/base/viewmodel/ViewError;", "getErrorsFlow", "()Lkotlinx/coroutines/flow/Flow;", "progressFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getProgressFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "emitError", "", "error", "(Leasy/app/base/network/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitLoadingState", "isLoading", "library_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _progressStateFlow = null;
    private final kotlinx.coroutines.flow.MutableSharedFlow<easy.app.base.network.DomainError> _errorsFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<easy.app.base.viewmodel.ViewError> errorsFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> progressFlow = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<easy.app.base.viewmodel.ViewError> getErrorsFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getProgressFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object emitError(@org.jetbrains.annotations.NotNull()
    easy.app.base.network.DomainError error, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public final void emitLoadingState(boolean isLoading) {
    }
    
    public BaseViewModel() {
        super();
    }
}