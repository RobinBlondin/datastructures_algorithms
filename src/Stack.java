public class Stack {
    private Node top;
    private int height;

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stack() {
        this.top = null;
        this.height = 0;
    }

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void printStack() {
        if (height == 0) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Top: " + top.value);
        System.out.println("Height: " + height);

        Node current = top;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.value + " -> ");
            } else {
                System.out.print(current.value);
            }
            current = current.next;
        }
        System.out.println();
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node pop() {
        if (height == 0) {
            return null;
        }

        Node temp = top;

        if (height == 1) {
            top = null;
        } else {
            top = top.next;
        }

        temp.next = null;
        height--;
        return temp;
    }
}
