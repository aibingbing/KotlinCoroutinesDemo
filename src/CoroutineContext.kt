import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.coroutineContext

fun log(msg: Job?) {
    println("[${Thread.currentThread().name}] $msg")
}

suspend inline fun Job.Key.currentJob() = coroutineContext[Job]

suspend fun coroutineJob() {
    GlobalScope.launch {
        log(Job.currentJob())
    }
    log(Job.currentJob())
}

//suspend fun main() {
//    coroutineJob()
//
//    GlobalScope.launch(CoroutineName("Hello")) {
//        log(1)
//    }
//}

class MyContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        log("<MyContinuation $result")
        continuation.resumeWith(result)
    }
}

class MyContinuationInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)
}

suspend fun main() {
    GlobalScope.launch(MyContinuationInterceptor()) {
        log(1)
        val job = async {
            log(2)
            delay(1000)
            log(3)
            "HelloWorld"
        }
        log(4)
        val result = job.await()
        log("5. $result")
    }.join()
    log(6)
}
