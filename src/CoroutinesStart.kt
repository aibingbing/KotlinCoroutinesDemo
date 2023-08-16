import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun log(msg: Any) {
    println("${LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))} [${Thread.currentThread().name}] $msg")
}

//suspend fun main(args: Array<String>) {
//    log(1)
//    val job = GlobalScope.launch {
//        log(2)
//    }
//    log(3)
//    job.join()
//    log(4)
//}

//suspend fun main(args: Array<String>) {
//    log(1)
//    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
//        log(2)
//    }
//    log(3)
//    job.start()
//    log(4)
//}

//suspend fun main(args: Array<String>) {
//    log(1)
//    val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
//        log(2)
//        delay(1000)
//        log(3)
//    }
//    job.cancel()
//    log(4)
//    job.join()
//}

suspend fun main(args: Array<String>) {
    log(1)
    val job = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
        log(2)
        delay(1000)
        log(3)
    }
    log(4)
    job.join()
    log(5)
}

//suspend fun main(args: Array<String>) {
//    log(1)
//    val job = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
//        log(2)
//        delay(1000)
//        log(3)
//    }
//    log(4)
//    job.start()
//    log(5)
//}