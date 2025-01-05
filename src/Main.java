import com.sun.source.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();

        System.out.println(traversal.breadthFirstSearch());

        System.out.println(traversal.depthFirstSearch(DFSOrder.PREORDER));
        System.out.println(traversal.depthFirstSearch(DFSOrder.INORDER));
        System.out.println(traversal.depthFirstSearch(DFSOrder.POSTORDER));
    }
}