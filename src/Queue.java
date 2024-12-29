public class Queue {
    private Node first;
    private Node last;
    private int length;

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        if(length == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("First: " + first.value);
        System.out.println("Last: " + last.value);
        System.out.println("Length: " + length);

        Node temp = first;
        while(temp != null) {
            if(temp.next != null) {
                System.out.print(temp.value + " -> ");
            } else {
                System.out.print(temp.value);
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if (length == 0) {
            return null;
        }
        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
