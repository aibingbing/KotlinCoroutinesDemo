import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.ArithmeticException

//suspend fun main() {
//    val ints = sequence<Int> {
//        (1..3).forEach {
//            yield(it)
//        }
//    }
//    for (element in ints) {
//        log(element)
//    }
//}

//suspend fun main() {
//    val intFlow = flow<Int> {
//        (1..3).forEach {
//            emit(it)
//            log("emit: $it")
//            delay(1000)
//        }
//    }
//    GlobalScope.launch {
//        intFlow.flowOn(Dispatchers.Unconfined)
//                .collect {
//                    withContext(Dispatchers.Default) {
//                        log("receive: $it")
//                    }
//                }
//    }.join()
//}

//suspend fun main() {
//    val intFlow = flow<Int> {
//        (1..3).forEach {
//            emit(it)
//            log("emit: $it")
//            delay(1000)
//        }
//    }
//    GlobalScope.launch {
//        intFlow.collect { log("receive: $it") }
//        intFlow.collect { log("receive1: $it") }
//    }.join()
//}

//suspend fun main() {
//    flow {
//        (1..100).forEach {
//            emit(it)
//        }
//    }.toList().forEach {
//        log(it)
//    }
//}

//fun createFlow() = flow<Int> {
//    (1..10).forEach {
//        emit(it)
//        delay(500)
//    }
//}.onEach {
//    log("emit: $it")
//}
//
//suspend fun main() {
////    GlobalScope.launch {
////        createFlow().collect {
////
////        }
////    }.join()
//
//    createFlow().delayEach(1000).collect {  }
//
//}

//fun main() {
//    createFlow().launchIn(GlobalScope)
//}

//suspend fun main() {
//    val job = GlobalScope.launch {
//        val intFlow = flow<Int> {
//            (1..10).forEach {
//                delay(500)
//                emit(it)
//            }
//        }
//        intFlow.collect {
//            log(it)
//        }
//    }
//    delay(2500)
//    job.cancelAndJoin()
//}

suspend fun main() {
    listOf<Int>(1, 2, 3, 4).asFlow()
    setOf<Int>(1, 2, 3, 4).asFlow()
    flowOf(1, 2, 3, 4)
}

//suspend fun main() {
//    flow<Int> {
//        List(100) {
//            emit(it)
//        }
//    }.conflate().collect { value ->
//        log("Collecting $it")
//        delay(100)
//        log("$it collected")
//    }
//}

//suspend fun main() {
//    flow<Int> {
//        List(100) {
//            emit(it)
//        }
//    }.collectLatest { value ->
//        log("Collecting $value")
//        delay(100)
//        log("$value collected")
//    }
//}

//suspend fun main() {
//    flow<Int> {
//        List(5) {
//            emit(it)
//        }
//    }.map {
//        it * 2
//    }
//
//    flow<Int> {
//        List(5) {
//            emit(it)
//        }
//    }.map {
//        flow<Int> {
//            List(it) {
//                emit(it)
//            }
//        }
//    }
//
//    flow<Int> {
//        List(5) {
//            emit(it)
//        }
//    }.map {
//        flow<Int> {
//            List(it) {
//                emit(it)
//            }
//        }
//    }.flattenConcat().collect {
//        log(it)
//    }
//}

//private fun getUserFromApi() = GlobalScope.async(Dispatchers.IO) {
//    delay(1000)
//    "{username=api}"
//}
//
//private fun getUserFromLocal() = GlobalScope.async(Dispatchers.IO) {
//    delay(500)
//    "{username=local}"
//}
//
//suspend fun main() {
//    coroutineScope {
//        listOf(::getUserFromApi, ::getUserFromLocal) //... ①
//                .map { function ->
//                    function.call() //... ②
//                }
//                .map { deferred ->
//                    flow { emit(deferred.await()) } //... ③
//                }
//                .merge() //... ④
//                .onEach { user ->
//                    println("Result: $user")
//                }.launchIn(this)
//    }
//}


