package DataStructure.Stack

class Stack<T> {
    private var top: Node<T>? = null
    private var size = 0

    fun push(item: T) {
        val node = Node(item)

        node.next = top
        top = node
        size++
    }

    fun pop(): T {
        if (top == null) throw NoSuchElementException("Stack is Empty")

        val data = top!!.data
        top = top!!.next
        size--
        return data
    }

    fun peek(): T? {
        return if (top == null) null else top!!.data
    }

    fun size(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return top == null
    }

    inner class Node<T>(item: T) {
        val data: T = item
        var next: Node<T>? = null
    }
}