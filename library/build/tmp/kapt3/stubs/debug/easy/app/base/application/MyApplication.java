package easy.app.base.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Leasy/app/base/application/MyApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "library_debug"})
@dagger.hilt.android.HiltAndroidApp()
public final class MyApplication extends android.app.Application {
    @org.jetbrains.annotations.Nullable()
    private static easy.app.base.application.MyApplication application;
    @org.jetbrains.annotations.NotNull()
    public static final easy.app.base.application.MyApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public MyApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Leasy/app/base/application/MyApplication$Companion;", "", "()V", "application", "Leasy/app/base/application/MyApplication;", "getApplication", "()Leasy/app/base/application/MyApplication;", "setApplication", "(Leasy/app/base/application/MyApplication;)V", "getInstance", "library_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final easy.app.base.application.MyApplication getApplication() {
            return null;
        }
        
        public final void setApplication(@org.jetbrains.annotations.Nullable()
        easy.app.base.application.MyApplication p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final easy.app.base.application.MyApplication getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}