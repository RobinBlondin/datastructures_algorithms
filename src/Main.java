public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(1, 2, 3, 4, 5);
        list.insert(5, 10);

        list.printAsc();
        list.printDesc();;
    }
}