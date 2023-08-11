import kotlinx.coroutines.*
import java.lang.ArithmeticException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//typealias Callback = (Int) -> Unit
//
//fun getCount(callback: Callback) {
//
//}

//suspend fun getCountCoroutine() = suspendCoroutine<Int> { continuation ->
//    getCount { count ->
//        continuation.resume(count)
//    }
//}

//getCountBtn.setOnClickListener {
//    GlobalScope.launch(Dispatchers.Main) {
//      userNameView.text = getCountCoroutine()
//    }
//}

//----------------------------------------------------------

interface Callback<T> {
    fun onSuccess(t: T)
    fun onError(t: Throwable)
}

fun getCount(callback: Callback<Int>) {

}

suspend fun getCountCoroutine() = suspendCoroutine<Int> { continuation ->
    getCount(object : Callback<Int> {
        override fun onSuccess(t: Int) {
            continuation.resume(t)
        }

        override fun onError(t: Throwable) {
            continuation.resumeWithException(t)
        }
    })
}

//val  loadCount = {
//    GlobalScope.launch (Dispatchers.Main){
//        try {
//            userNameView.text = getCountCoroutine()
//        } catch (e: Exception) {
//            userNameView.text = "Get Count Error:$e"
//        }
//    }
//}

//全局异常处理
//fun main() {
//    Thread.setDefaultUncaughtExceptionHandler { t, e ->
//        print("Thread ${t.name} throws an exception with message ${e.message}")
//    }
//    throw ArithmeticException("Hey")
//}

//suspend fun main() {
//    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        log("Throws an exception with message: ${throwable.message}")
//    }
//    log(1)
//    GlobalScope.launch (context = exceptionHandler){
//        throw ArithmeticException("Hey")
//    }.join()
//    log(2)
//}

suspend fun main() {
    log(1)
    try {
        supervisorScope {
            log(2)
            launch {
                log(3)
                launch {
                    log(4)
                    delay(100)
                    throw  ArithmeticException("Hey!")
                }
                log(5)
            }
            log(6)
            val job = launch {
                log(7)
                delay(1000)
            }
            try {
                log(8)
                job.join()
                log(9)
            } catch (e: Exception) {
                log("10 $e")
            }
        }
        log(11)
    } catch (e: Exception) {
        log("12 $e")
    }
    log(13)
}
