package easy.app.base.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Leasy/app/base/extension/ActionDebouncer;", "", "action", "Lkotlin/Function1;", "Landroid/view/View;", "", "(Lkotlin/jvm/functions/Function1;)V", "lastActionTime", "", "notifyAction", "view", "Companion", "library_debug"})
final class ActionDebouncer {
    private long lastActionTime = 0L;
    private final kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> action = null;
    public static final long DEBOUNCE_INTERVAL_MILLISECONDS = 600L;
    @org.jetbrains.annotations.NotNull()
    public static final easy.app.base.extension.ActionDebouncer.Companion Companion = null;
    
    public final void notifyAction(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public ActionDebouncer(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> action) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Leasy/app/base/extension/ActionDebouncer$Companion;", "", "()V", "DEBOUNCE_INTERVAL_MILLISECONDS", "", "library_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}