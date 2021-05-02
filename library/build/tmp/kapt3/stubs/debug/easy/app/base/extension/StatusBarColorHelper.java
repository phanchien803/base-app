package easy.app.base.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\tH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Leasy/app/base/extension/StatusBarColorHelper;", "Landroidx/lifecycle/LifecycleObserver;", "activity", "Landroid/app/Activity;", "color", "", "(Landroid/app/Activity;I)V", "originalColor", "restoreOriginalColor", "", "setLifecycle", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "setNewColor", "library_debug"})
public final class StatusBarColorHelper implements androidx.lifecycle.LifecycleObserver {
    private int originalColor = android.graphics.Color.WHITE;
    private final android.app.Activity activity = null;
    private final int color = 0;
    
    public final void setLifecycle(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    private final void setNewColor() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    private final void restoreOriginalColor() {
    }
    
    public StatusBarColorHelper(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.ColorRes()
    int color) {
        super();
    }
}