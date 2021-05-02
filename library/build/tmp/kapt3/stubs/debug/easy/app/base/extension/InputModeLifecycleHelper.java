package easy.app.base.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0003J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\nH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Leasy/app/base/extension/InputModeLifecycleHelper;", "Landroidx/lifecycle/LifecycleObserver;", "window", "Landroid/view/Window;", "mode", "Leasy/app/base/extension/InputModeLifecycleHelper$Mode;", "(Landroid/view/Window;Leasy/app/base/extension/InputModeLifecycleHelper$Mode;)V", "originalMode", "", "restoreOriginalSoftInputMode", "", "setLifecycle", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "setNewSoftInputMode", "Mode", "library_debug"})
public final class InputModeLifecycleHelper implements androidx.lifecycle.LifecycleObserver {
    private int originalMode = android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED;
    private android.view.Window window;
    private final easy.app.base.extension.InputModeLifecycleHelper.Mode mode = null;
    
    public final void setLifecycle(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    private final void setNewSoftInputMode() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    private final void restoreOriginalSoftInputMode() {
    }
    
    public InputModeLifecycleHelper(@org.jetbrains.annotations.Nullable()
    android.view.Window window, @org.jetbrains.annotations.NotNull()
    easy.app.base.extension.InputModeLifecycleHelper.Mode mode) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Leasy/app/base/extension/InputModeLifecycleHelper$Mode;", "", "(Ljava/lang/String;I)V", "ADJUST_RESIZE", "ADJUST_PAN", "library_debug"})
    public static enum Mode {
        /*public static final*/ ADJUST_RESIZE /* = new ADJUST_RESIZE() */,
        /*public static final*/ ADJUST_PAN /* = new ADJUST_PAN() */;
        
        Mode() {
        }
    }
}