import kotlinx.coroutines.*

fun MainScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

val mainScope = MainScope()
suspend fun main() {
    mainScope.launch {
        log(1)
        val job = async(Dispatchers.IO) {
            log(2)
            delay(1000)
            log(3)
            "HelloWorld"
        }.await()
        log(4)
    }.join()
}