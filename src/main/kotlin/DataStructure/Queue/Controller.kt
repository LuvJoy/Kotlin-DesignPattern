package DataStructure.Queue

import DataStructure.Queue.Queue

fun main() {
    val a = Queue<Int>()
    a.add(1)
    a.add(2)
    a.add(3)
    a.add(4)
    println(a.remove())
    println(a.remove())
    println(a.peek())
    println(a.remove())
    println(a.isEmpty())
    println(a.remove())
    println(a.isEmpty())
}