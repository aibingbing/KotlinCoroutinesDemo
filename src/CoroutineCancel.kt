import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//fun main() = runBlocking {
//    val job1 = launch {
//        log(1)
//        delay(1000)
//        log(2)
//    }
//    delay(100)
//    log(3)
//    job1.cancel()
//    log(4)
//}

//fun main() = runBlocking {
//    val job1 = launch {
//        log(1)
//        try {
//            delay(1000)
//        } catch (e: Exception) {
//            log("canceled. $e")
//        }
//        log(2)
//    }
//    delay(100)
//    log(3)
//    job1.cancel()
//    log(4)
//}

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    log("Throws an exception with message: ${throwable.message}")
}

suspend fun main() {
    GlobalScope.launch(exceptionHandler) {
        val job1 = launch(exceptionHandler) {
            log(1)
            delay(1000)
            log(2)
        }
        delay(100)
        log(3)
        job1.cancel()
        log(4)
    }.join()
}
