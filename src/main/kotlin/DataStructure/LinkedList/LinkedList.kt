package DataStructure.LinkedList

class LinkedList<T> {
    var size: Int = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun addFirst(item: T) {
        val newNode = Node<T>().apply {
            this.item = item
            this.next = head
        }
        head = newNode
        if (head?.next == null) {
            tail = head
        }
        size++
    }

    fun addLast(item: T) {
        if (size == 0) {
            addFirst(item)
        } else {
            val newNode = Node<T>().apply {
                this.item = item
            }
            tail?.next = newNode
            tail = newNode
            size++
        }
    }

    fun addAt(index: Int, item: T) {
        if (index > size - 1) {
            error("invalid index")
        }

        if (index == 0) {
            addFirst(item)
        } else {
            val newNode = Node<T>().apply {
                this.item = item
            }
            val node = find(index)!!
            val temp = node.next
            newNode.next = temp
            node.next = newNode

            if (newNode.next == null) {
                tail = newNode
            }
            size++
        }
    }

    fun removeFirst(): T {
        val node = head
        head = node?.next!!
        size--
        return node?.item ?: error("invalid item")
    }

    fun removeAt(index: Int): T {
        if (index > size - 1) {
            error("invalid position")
        }

        return if (index == 0) {
            removeFirst()
        } else {
            val node = find(index - 1)
            val deletedNode = node?.next
            node?.next = node?.next?.next
            size--
            deletedNode?.item ?: error("invalid item")
        }
    }

    fun find(index: Int): Node<T>? {
        var node = head
        for (i in 0 until index) {
            node = node?.next ?: error("invalid node")
        }
        return node
    }

    fun printAll() {
        var node = head
        while (node != null) {
            println(node.item)
            node = node.next
        }
    }

    inner class Node<T> {
        var next: Node<T>? = null
        var item: T? = null
    }
}