package easy.app.base.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Leasy/app/base/viewmodel/ViewError;", "", "()V", "ResourceError", "StringError", "Leasy/app/base/viewmodel/ViewError$ResourceError;", "Leasy/app/base/viewmodel/ViewError$StringError;", "library_debug"})
public abstract class ViewError {
    
    private ViewError() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Leasy/app/base/viewmodel/ViewError$ResourceError;", "Leasy/app/base/viewmodel/ViewError;", "resId", "", "(I)V", "getResId", "()I", "library_debug"})
    public static final class ResourceError extends easy.app.base.viewmodel.ViewError {
        private final int resId = 0;
        
        public final int getResId() {
            return 0;
        }
        
        public ResourceError(int resId) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Leasy/app/base/viewmodel/ViewError$StringError;", "Leasy/app/base/viewmodel/ViewError;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "library_debug"})
    public static final class StringError extends easy.app.base.viewmodel.ViewError {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String error = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getError() {
            return null;
        }
        
        public StringError(@org.jetbrains.annotations.NotNull()
        java.lang.String error) {
            super();
        }
    }
}