package easy.app.base.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u001a\n\u0010\u0013\u001a\u00020\u0011*\u00020\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\b\u0003\u0010\u0016\u001a\u00020\u0001\u001a0\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00180\u001bH\u0086\b\u00f8\u0001\u0000\u001a\n\u0010\u001c\u001a\u00020\u0011*\u00020\t\u001a\u001e\u0010\u001d\u001a\u00020\u0011*\u00020\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u001b\u001a\n\u0010\u001f\u001a\u00020\u0011*\u00020\t\u001a\n\u0010 \u001a\u00020\u0011*\u00020!\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"(\u0010\b\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2 = {"dp", "", "getDp", "(I)I", "px", "getPx", "value", "", "visible", "Landroid/view/View;", "getVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "actionbarHeight", "Landroid/app/Activity;", "hide", "", "gone", "hideKeyBoard", "Landroidx/fragment/app/Fragment;", "initViewStatusBar", "backgroundColor", "mapInPlace", "T", "", "mutator", "Lkotlin/Function1;", "removeOnDebouncedClickListener", "setOnDebouncedClickListener", "action", "show", "updateMarginWindowInsets", "Landroidx/appcompat/widget/Toolbar;", "library_debug"})
public final class ViewExtensionsKt {
    
    public static final void setOnDebouncedClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setOnDebouncedClickListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> action) {
    }
    
    public static final void removeOnDebouncedClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View $this$removeOnDebouncedClickListener) {
    }
    
    public static final boolean getVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
        return false;
    }
    
    public static final void setVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible, boolean value) {
    }
    
    public static final void hide(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hide, boolean gone) {
    }
    
    public static final void show(@org.jetbrains.annotations.NotNull()
    android.view.View $this$show) {
    }
    
    public static final void initViewStatusBar(@org.jetbrains.annotations.NotNull()
    android.view.View $this$initViewStatusBar, @androidx.annotation.ColorRes()
    int backgroundColor) {
    }
    
    public static final void updateMarginWindowInsets(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.Toolbar $this$updateMarginWindowInsets) {
    }
    
    public static final int actionbarHeight(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$actionbarHeight) {
        return 0;
    }
    
    public static final <T extends java.lang.Object>void mapInPlace(@org.jetbrains.annotations.NotNull()
    java.util.List<T> $this$mapInPlace, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends T> mutator) {
    }
    
    public static final int getDp(int $this$dp) {
        return 0;
    }
    
    public static final int getPx(int $this$px) {
        return 0;
    }
    
    public static final void hideKeyBoard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$hideKeyBoard) {
    }
}