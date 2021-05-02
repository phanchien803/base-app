package easy.app.base.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0006\u001a>\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH\u0086\b\u00f8\u0001\u0000\u001a%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u0002H\b\u00a2\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u00012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\u00100\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2 = {"error", "Leasy/app/base/network/Result;", "E", "", "Leasy/app/base/network/DomainError;", "value", "(Leasy/app/base/network/DomainError;)Leasy/app/base/network/Result;", "safeCallApi", "V", "errorClass", "Lkotlin/reflect/KClass;", "Leasy/app/base/network/BackendTypedError;", "action", "Lkotlin/Function0;", "(Ljava/lang/Object;)Leasy/app/base/network/Result;", "map", "R", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "curValue", "library_debug"})
public final class ApiHelperKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final <V extends java.lang.Object>easy.app.base.network.Result value(V value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <E extends easy.app.base.network.DomainError>easy.app.base.network.Result error(@org.jetbrains.annotations.NotNull()
    E value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <V extends java.lang.Object>easy.app.base.network.Result<easy.app.base.network.DomainError, V> safeCallApi(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<? extends easy.app.base.network.BackendTypedError> errorClass, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends V> action) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <E extends easy.app.base.network.DomainError, V extends java.lang.Object, R extends java.lang.Object>easy.app.base.network.Result<E, R> map(@org.jetbrains.annotations.NotNull()
    easy.app.base.network.Result<? extends E, ? extends V> $this$map, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super V, ? extends R> block) {
        return null;
    }
}