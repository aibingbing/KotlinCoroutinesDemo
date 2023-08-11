import kotlinx.coroutines.*
import java.util.concurrent.Executors

//suspend fun main() {
//    val myDispatcher = Executors.newSingleThreadExecutor { r ->
//        Thread(r, "MyThread")
//    }.asCoroutineDispatcher()
//
//    GlobalScope.launch(myDispatcher) {
//        log(1)
//    }.join()
//    log(2)
//    myDispatcher.close()
//}

suspend fun main() {
    Executors.newFixedThreadPool(10)
            .asCoroutineDispatcher()
            .use { dispatcher ->
                GlobalScope.launch(dispatcher) {
                    log(1)
                    val job = async {
                        log(2)
                        delay(1000)
                        log(3)
                        "Hello"
                    }
                    log(4)
                    val result = job.await()
                    log("5. $result")
                }.join()
                log(6)
            }


}
