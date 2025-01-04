import com.sun.source.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.recursiveInsert(10);
        binaryTree.recursiveInsert(20);
        binaryTree.recursiveInsert(5);
        binaryTree.recursiveInsert(35);
        binaryTree.recursiveInsert(13);
        binaryTree.recursiveInsert(15);
        boolean res = binaryTree.contains(15);
        System.out.println(res);
        binaryTree.deleteNode(15);
        res = binaryTree.contains(15);
        System.out.println(res);
    }
}