import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//suspend fun main() {
//    log(1)
//    GlobalScope.launch {
//        log(2)
//    }
//    log(3)
//}

//suspend fun main() {
//    log(1)
//    GlobalScope.launch {
//        log(2)
//    }
//    log(3)
//    Thread.sleep(1000)
//}

//suspend fun main() {
//    log(1)
//    GlobalScope.launch {
//        log(2)
//    }.join()
//    log(3)
//}

fun main() = runBlocking {
    log(1)
    GlobalScope.launch {
        log(2)
    }
    log(3)
}
