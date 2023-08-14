

val fibonacci = sequence {
    yield(1L)
    var cur = 1L
    var next = 1L
    while (true) {
        yield(next)
        val tmp = cur + next
        cur = next
        next = tmp
    }
}

val seq = sequence {
    log("yield 1,2,3")
    yieldAll(listOf(1,2,3))
    log("yield 4,5,6")
    yieldAll(listOf(4,5,6))
    log("yield 7,8,9")
    yieldAll(listOf(7,8,9))
}

fun main() {
    fibonacci.take(5).forEach(::log)
    log("-----------------")
    seq.take(5).forEach(::log)
}