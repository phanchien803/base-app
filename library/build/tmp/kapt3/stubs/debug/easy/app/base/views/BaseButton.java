package easy.app.base.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u001b\u001a\u00020\u00182\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00180\u001dJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Leasy/app/base/views/BaseButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Leasy/app/databinding/LayoutBaseButtonBinding;", "buttonText", "", "buttonTextColor", "buttonTextFont", "buttonTextSize", "currentDrawable", "Landroid/graphics/drawable/Drawable;", "disableDrawable", "iconDrawable", "isEnable", "", "loading", "setEnable", "", "setIcon", "icon", "setOnDebouncedClickListener", "clickListener", "Lkotlin/Function1;", "Landroid/view/View;", "setText", "text", "setViewOnClickListener", "Landroid/view/View$OnClickListener;", "startLoading", "stopLoading", "Companion", "library_debug"})
public final class BaseButton extends android.widget.FrameLayout {
    private java.lang.String buttonText = "";
    private int buttonTextSize = 0;
    private int buttonTextColor = 0;
    private int buttonTextFont = 0;
    private android.graphics.drawable.Drawable iconDrawable;
    private android.graphics.drawable.Drawable disableDrawable;
    private android.graphics.drawable.Drawable currentDrawable;
    private boolean loading = false;
    private boolean isEnable = true;
    private final easy.app.databinding.LayoutBaseButtonBinding binding = null;
    @org.jetbrains.annotations.NotNull()
    public static final easy.app.base.views.BaseButton.Companion Companion = null;
    
    public final void setViewOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener clickListener) {
    }
    
    public final void setOnDebouncedClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> clickListener) {
    }
    
    public final void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setIcon(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable icon) {
    }
    
    public final void startLoading() {
    }
    
    public final void stopLoading() {
    }
    
    public final void setEnable(boolean isEnable) {
    }
    
    public BaseButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public BaseButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public BaseButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Leasy/app/base/views/BaseButton$Companion;", "", "()V", "ButtonType", "library_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Leasy/app/base/views/BaseButton$Companion$ButtonType;", "", "value", "", "(Ljava/lang/String;II)V", "BUTTON_TYPE_NORMAL", "BUTTON_TYPE_OUTLINED", "BUTTON_TYPE_TEXT", "library_debug"})
        public static enum ButtonType {
            /*public static final*/ BUTTON_TYPE_NORMAL /* = new BUTTON_TYPE_NORMAL(0) */,
            /*public static final*/ BUTTON_TYPE_OUTLINED /* = new BUTTON_TYPE_OUTLINED(0) */,
            /*public static final*/ BUTTON_TYPE_TEXT /* = new BUTTON_TYPE_TEXT(0) */;
            
            ButtonType(int value) {
            }
        }
    }
}