package DataStructure.Queue

class Queue<T> {
    inner class Node<T>(
        var data: T
    ) {
        var next: Node<T>? = null
    }
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun add(item: T) {
        val t = Node(item)

        if (last != null) {
            last!!.next = t
        }
        last = t
        if (first == null) {
            first = t
        }
    }

    fun remove(): T {
        if (first == null) {
            throw NoSuchElementException()
        }

        val data: T = first!!.data
        first = first!!.next

        if (first == null) {
            last = null
        }
        return data
    }

    fun peek(): T {
        if (first == null) {
            throw NoSuchElementException()
        }
        return first!!.data
    }

    fun isEmpty(): Boolean {
        return first == null
    }
}

