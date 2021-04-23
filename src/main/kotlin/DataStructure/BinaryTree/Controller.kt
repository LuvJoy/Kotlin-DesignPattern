package DataStructure.BinaryTree

fun main() {
    val tree = BinaryTree()
    val n4 = tree.makeNode(null, 4, null)
    val n5 = tree.makeNode(null, 5, null)
    val n2 = tree.makeNode(n4, 2, n5)
    val n3 = tree.makeNode(null, 3, null)
    val n1 = tree.makeNode(n2, 1, n3)

    tree.root = n1
    // Inorder (left, root, right) : 4 2 5 1 3
    tree.inOrder(tree.root)
    // Preorder (root, left, right) : 1 2 4 5 3
    tree.preOrder(tree.root)
    // Postorder (left, right, root) : 4 5 2 3 1
    tree.postOrder(tree.root)
}