package easy.app.base.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J9\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2%\b\u0002\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f\u0018\u00010\u001dJ9\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2%\b\u0002\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Leasy/app/base/fragment/AlertDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "isAutoDismiss", "", "negativeButtonClickListener", "Landroid/view/View$OnClickListener;", "negativeButtonText", "", "positiveButtonClickListener", "positiveButtonText", "handleConfirmType", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setAutoDismiss", "autoDismiss", "setNegativeButton", "actionText", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dialog", "setPositiveButton", "Companion", "library_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AlertDialogFragment extends androidx.fragment.app.DialogFragment {
    private boolean isAutoDismiss = true;
    private java.lang.String positiveButtonText;
    private android.view.View.OnClickListener positiveButtonClickListener;
    private java.lang.String negativeButtonText;
    private android.view.View.OnClickListener negativeButtonClickListener;
    private static final java.lang.String ALERT_TYPE = "alert_type";
    private static final java.lang.String MESSAGE = "message";
    @org.jetbrains.annotations.NotNull()
    public static final easy.app.base.fragment.AlertDialogFragment.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleConfirmType(android.view.View view) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final easy.app.base.fragment.AlertDialogFragment setAutoDismiss(boolean autoDismiss) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final easy.app.base.fragment.AlertDialogFragment setPositiveButton(@org.jetbrains.annotations.Nullable()
    java.lang.String actionText, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super androidx.fragment.app.DialogFragment, kotlin.Unit> listener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final easy.app.base.fragment.AlertDialogFragment setNegativeButton(@org.jetbrains.annotations.Nullable()
    java.lang.String actionText, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super androidx.fragment.app.DialogFragment, kotlin.Unit> listener) {
        return null;
    }
    
    public AlertDialogFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Leasy/app/base/fragment/AlertDialogFragment$Companion;", "", "()V", "ALERT_TYPE", "", "MESSAGE", "newConfirmInstance", "Leasy/app/base/fragment/AlertDialogFragment;", "message", "newInstance", "alertType", "Leasy/app/base/fragment/AlertType;", "library_debug"})
    public static final class Companion {
        
        private final easy.app.base.fragment.AlertDialogFragment newInstance(easy.app.base.fragment.AlertType alertType) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final easy.app.base.fragment.AlertDialogFragment newConfirmInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}