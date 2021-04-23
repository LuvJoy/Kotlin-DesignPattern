package DataStructure.BinaryTree

class BinaryTree {
    var root: Node? = null

    fun makeNode(left: Node?, data: Int, right: Node?): Node {
        return Node().apply {
            this.data = data
            this.left = left
            this.right = right
        }
    }

    fun inOrder(node: Node?) {
        node?.let {
            inOrder(node.left)
            println(node.data)
            inOrder(node.right)
        }
    }

    fun preOrder(node: Node?) {
        node?.let {
            println(node.data)
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    fun postOrder(node: Node?) {
        node?.let {
            postOrder(node.left)
            postOrder(node.right)
            println(node.data)
        }
    }

    inner class Node() {
        var data: Int? = null
        var left: Node? = null
        var right: Node? = null
    }
}