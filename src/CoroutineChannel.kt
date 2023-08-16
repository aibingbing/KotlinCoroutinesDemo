import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.kotlin.daemon.common.experimental.sendSignature

//suspend fun main() {
//    val channel = Channel<Int>()
//
//    val producer = GlobalScope.launch {
//        var i = 0
//        while (true) {
//            channel.send(i++)
//            delay(1000)
//        }
//    }
//
//    val consumer = GlobalScope.launch {
//        while (true) {
//            val element = channel.receive()
//            log(element)
//        }
//    }
//
//    producer.join()
//    consumer.join()
//}

//suspend fun main() {
//    val channel = Channel<Int>()
//
//    val producer = GlobalScope.launch {
//        var i = 0
//        while (true) {
//            i++
//            log("before send: $i")
//            channel.send(i)
//            log("after send: $i")
//            delay(1000)
//        }
//    }
//
//    val consumer = GlobalScope.launch {
//        while (true) {
//            delay(2000)
//            val element = channel.receive()
//            log(element)
//        }
//    }
//
//    producer.join()
//    consumer.join()
//}

//suspend fun main() {
//    val channel = Channel<Int>()
//
//    val producer = GlobalScope.launch {
//        var i = 0
//        while (true) {
//            i++
//            log("before send: $i")
//            channel.send(i)
//            log("after send: $i")
//            delay(1000)
//        }
//    }
//
//    val consumer = GlobalScope.launch {
//        val iterator = channel.iterator()
//        while (iterator.hasNext()) {
//            val element = iterator.next()
//            log(element)
//            delay(2000)
//        }
//    }
//
//    producer.join()
//    consumer.join()
//}

//suspend fun main() {
//    val channel = Channel<Int>()
//
//    val producer = GlobalScope.launch {
//        var i = 0
//        while (true) {
//            i++
//            log("before send: $i")
//            channel.send(i)
//            log("after send: $i")
//            delay(1000)
//        }
//    }
//
//    val consumer = GlobalScope.launch {
//        for (element in channel) {
//            log(element)
//            delay(2000)
//        }
//    }
//
//    producer.join()
//    consumer.join()
//}

//suspend fun main() {
//    val receiveChannel: ReceiveChannel<Int> = GlobalScope.produce {
//        var i = 0
//        while (true) {
//            delay(1000)
//            send(i++)
//        }
//    }
//    val consumer = GlobalScope.launch {
//        for (element in receiveChannel) {
//            log(element)
//        }
//    }
//    consumer.join()
//}

//suspend fun main() {
//    val sendChannel: SendChannel<Int> = GlobalScope.actor<Int> {
//        while (true) {
//            val element = receive()
//            log(element)
//        }
//    }
//    val producer = GlobalScope.launch {
//        var i = 0
//        while (true) {
//            delay(1000)
//            sendChannel.send(i++)
//        }
//    }
//    producer.join()
//}

//suspend fun main() {
//    val receiveChannel: ReceiveChannel<Int> = GlobalScope.produce<Int> {
//        var i = 0
//        while (true) {
//            delay(1000)
//            send(i++)
//        }
//    }
//    val consumer = GlobalScope.launch {
//        while (true) {
//            val element = receiveChannel.receive()
//            log(element)
//        }
//    }
//    consumer.join()
//}

//suspend fun main() {
//    val channel = Channel<Int>(3)
//    val producer = GlobalScope.launch {
//        List(5) {
//            channel.send(it)
//            log("send: $it")
//        }
//        channel.close()
//        log("close channel: [CloseForSend=${channel.isClosedForSend}], [CloseForReceive=${channel.isClosedForReceive}]")
//    }
//    val consumer = GlobalScope.launch {
//        for (element in channel) {
//            log("receive: $element")
//            delay(1000)
//        }
//        log("After ConSumeing:[CloseForSend=${channel.isClosedForSend}], [CloseForReceive=${channel.isClosedForReceive}]")
//    }
//    producer.join()
//    consumer.join()
//}

//suspend fun main() {
//    val channel = GlobalScope.produce(Dispatchers.Unconfined) {
//        log("A")
//        send(1)
//        log("B")
//        send(2)
//        log("Done")
//    }
//    for (element in channel) {
//        log("Got $element")
//    }
//}

suspend fun main() {
    val sequence = sequence<Int> {
        log("A")
        yield(1)
        log("B")
        yield(2)
        log("Done")
    }
    log("before sequence")
    for (item in sequence) {
        log("Got $item")
    }
}
