package easy.app.base.network

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException
import kotlin.reflect.KClass

sealed class Result<out E : DomainError, out V> {
    data class Failure<E : DomainError>(val error: E) : Result<E, Nothing>()
    data class Value<out V>(val value: V) : Result<Nothing, V>()
}


fun <V> value(value: V): Result<Nothing, V> = Result.Value(value)

fun <E : DomainError> error(value: E): Result<E, Nothing> = Result.Failure(value)


inline fun <V> safeCallApi(errorClass: KClass<out BackendTypedError> = BaseError::class, action: () -> V): Result<DomainError, V> =
        try {
            value(action())
        } catch (httpException: HttpException) {
            val httpCode = httpException.code()
            val httpMessage = httpException.message ?: ""
            val httpBody = httpException.response()?.errorBody()?.string()
            try {
                error(when (httpBody) {
                    null -> DomainError.ApiError(httpCode, httpMessage)
                    else -> DomainError.ApiError(httpCode, httpMessage, Gson().fromJson(httpBody, errorClass.java))
                })
            } catch (e: Exception) {
                error(when {
                    (e is JsonSyntaxException && httpCode >= 500) -> {
                        DomainError.ApiError(httpCode, httpMessage, null)
                    }
                    else -> DomainError.SystemException(e)
                })
            }
        } catch (e: Exception) {
            error(when (e) {
                is UnknownHostException -> DomainError.NetworkException(e) //Unable to locate the server. Please check your network connection.
                is ConnectException -> DomainError.NetworkException(e) //Unable to connect to the server. Please check your network connection.
                is SocketTimeoutException -> DomainError.NetworkException(e) //The connection has timed out. Please try again.
                is SocketException -> DomainError.NetworkException(e) //There are some problems with the connection. Please try again.
                is SSLHandshakeException -> DomainError.NetworkException(e) // Your connection is not private.
                is JsonSyntaxException -> {
                    DomainError.SystemException(e)
                } // Your connection is not private.
                else -> DomainError.SystemException(e)
            })
        }

fun <E : DomainError, V, R> Result<E, V>.map(block: (curValue: V) -> R): Result<E, R> = when (this) {
    is Result.Failure -> Result.Failure(error = error)
    is Result.Value -> Result.Value(value = block(value))
}