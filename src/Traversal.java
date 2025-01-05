import java.util.*;
import java.util.Queue;

public class Traversal {
    BinarySearchTree bst;

    public Traversal() {
        bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(10);
        bst.insert(25);
        bst.insert(35);
        bst.insert(45);
        bst.insert(55);
        bst.insert(65);
        bst.insert(75);
        bst.insert(85);
    }

    public List<Integer> breadthFirstSearch() {
        Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        queue.add(bst.getRoot());
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            BinarySearchTree.Node node = queue.poll();
            list.add(node.value);

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    public List<Integer> depthFirstSearch(DFSOrder order) {
        List<Integer> list = new ArrayList<>();

        class Traverse {
            Traverse(BinarySearchTree.Node node) {

                if(order == DFSOrder.PREORDER) {
                    list.add(node.value);
                }

                if(node.left != null) {
                    new Traverse(node.left);
                }

                if(order == DFSOrder.INORDER) {
                    list.add(node.value);
                }

                if(node.right != null) {
                    new Traverse(node.right);
                }

                if(order == DFSOrder.POSTORDER) {
                    list.add(node.value);
                }
            }
        }
        new Traverse(bst.getRoot());

        return list;
    }





}
