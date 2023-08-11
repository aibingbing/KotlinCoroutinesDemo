import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

data class User(val name: String, val age: Int)

//typealias CallBack = (User) -> Unit
//
//fun getUser(callback: CallBack) {
//    callback(User("aaa", 18))
//}
//
//suspend fun getUserCoroutine() = suspendCoroutine<User> { continuation ->
//    getUser {
//        continuation.resume(it)
//    }
//}
//
//suspend fun main() {
//    GlobalScope.launch {
//        val user = getUserCoroutine()
//        log("user=${user.name}, ${user.age}")
//    }
//}

// ---------------------------------------------------------------------------
interface CallBack<T> {
    fun onSuccess(value: T)
    fun onError(t: Throwable)
}

fun getUser(callback: CallBack<User>) {
    callback.onSuccess(User("aaa", 18))
}

suspend fun getUserCoroutine() = suspendCoroutine<User> { continuation ->
    getUser(object : CallBack<User> {
        override fun onSuccess(value: User) {
            continuation.resume(value)
        }

        override fun onError(t: Throwable) {
            continuation.resumeWithException(t)
        }
    })
}

fun main() {
    GlobalScope.launch {
        try {
            log("User.name=${getUserCoroutine().name}")
        } catch (e: Exception) {
            log("User Error=${e.message}")
        }
    }
}
