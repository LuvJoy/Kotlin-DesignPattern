package DataStructure.Stack

fun main() {
    val stack = Stack<Int>()
    stack.push(3)
    stack.push(4)
    stack.push(5)
    stack.push(6)
    stack.pop()

    println("---[3, 4, 5]")
    println(stack.size())
    println(stack.peek())
    println(stack.isEmpty())

    stack.pop()
    stack.pop()
    stack.pop()

    println("---[]")
    println(stack.size())
    println(stack.peek())
    println(stack.isEmpty())
}