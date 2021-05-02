package easy.app.base.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0004J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001c"}, d2 = {"Leasy/app/base/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "isFromBackStack", "", "viewModel", "Leasy/app/base/viewmodel/BaseViewModel;", "getViewModel", "()Leasy/app/base/viewmodel/BaseViewModel;", "handleOnBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStart", "onViewCreated", "view", "Landroid/view/View;", "showError", "errorMessage", "", "showProgress", "visible", "viewOwnerLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewOwnerLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "library_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public abstract class BaseFragment extends androidx.fragment.app.Fragment {
    private boolean isFromBackStack = false;
    
    protected final boolean isFromBackStack() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract easy.app.base.viewmodel.BaseViewModel getViewModel();
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.lifecycle.LifecycleCoroutineScope viewOwnerLifecycleScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.lifecycle.Lifecycle viewOwnerLifecycle() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void showProgress(boolean visible) {
    }
    
    protected final void handleOnBackPressed() {
    }
    
    private final void showError(java.lang.String errorMessage) {
    }
    
    public BaseFragment() {
        super();
    }
}