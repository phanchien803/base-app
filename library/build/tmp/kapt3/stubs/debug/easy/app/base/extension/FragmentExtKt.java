package easy.app.base.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0002\u001a\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\u0002\u00a8\u0006\r"}, d2 = {"canNavigate", "", "Landroidx/fragment/app/Fragment;", "navigateSafe", "", "directions", "Landroidx/navigation/NavDirections;", "navOptions", "Landroidx/navigation/NavOptions;", "popAllBackStack", "viewLifecycle", "Lkotlin/properties/ReadWriteProperty;", "T", "library_debug"})
public final class FragmentExtKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>kotlin.properties.ReadWriteProperty<androidx.fragment.app.Fragment, T> viewLifecycle(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$viewLifecycle) {
        return null;
    }
    
    public static final void navigateSafe(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$navigateSafe, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavDirections directions, @org.jetbrains.annotations.Nullable()
    androidx.navigation.NavOptions navOptions) {
    }
    
    /**
     * Returns true if the navigation controller is still pointing at 'this' fragment, or false
     * if it already navigated away.
     */
    public static final boolean canNavigate(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$canNavigate) {
        return false;
    }
    
    public static final void popAllBackStack(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$popAllBackStack) {
    }
}