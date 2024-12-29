public class BinarySearchTree {
    private Node root;

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            } else if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            } else {
                return false;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }

        Node temp = root;
        while (temp != null) {
            if (value == temp.value) {
                return true;
            }

            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }
}
