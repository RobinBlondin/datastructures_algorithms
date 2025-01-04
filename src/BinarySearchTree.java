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

    private boolean recursiveContains(int value, Node current) {
        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        if (value < current.value) {
            return recursiveContains(value, current.left);
        }

        return recursiveContains(value, current.right);
    }

    public boolean recursiveContains(int value) {
        return recursiveContains(value, root);
    }

    private Node recursiveInsert(int value, Node current) {

        if (current == null) {
            return new Node(value);
        }

        if (current.value == value) {
            return null;
        }

        if(value < current.value) {
            current.left = recursiveInsert(value, current.left);
        } else {
            current.right = recursiveInsert(value, current.right);
        }

        return current;
    }

    public void recursiveInsert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        recursiveInsert(value, root);
    }

    public int minValue(Node current) {
        if (current.left == null) {
            return current.value;
        }

        current = current.left;
        return minValue(current);
    }

    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.value) {
            current.right = deleteNode(current.right, value);
        } else {
            if(current.left == null && current.right == null) {
                return null;
            } else if (current.left != null && current.right != null) {
                int min = minValue(current.right);
                current.value = min;
                deleteNode(current.right, min);
            } else if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        root = deleteNode(root, value);
    }


}
