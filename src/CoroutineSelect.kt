import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select


suspend fun main() {
    val getUserFromApi = GlobalScope.async(Dispatchers.IO) {
        delay(1000)
        "{username=api}"
    }
    val getUserFromLocal = GlobalScope.async(Dispatchers.IO) {
        delay(500)
        "{username=local}"
    }
    GlobalScope.launch {
        val userResponse = select<String> {
            getUserFromApi.onAwait { it }
            getUserFromLocal.onAwait { it }
        }
        log("getUser: $userResponse")
    }.join()
}