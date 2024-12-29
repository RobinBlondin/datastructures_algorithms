public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(60);

        System.out.println(tree.getRoot().right.value);
        System.out.println(tree.contains(30));
        System.out.println(tree.contains(70));
    }
}