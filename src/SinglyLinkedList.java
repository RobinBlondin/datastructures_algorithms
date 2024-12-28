public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public SinglyLinkedList(int... numbers) {
        head = new Node(numbers[0]);
        tail = new Node(numbers[numbers.length - 1]);
        Node temp = head;

        for (int i = 1; i <= numbers.length - 1; i++) {
            temp.next = new Node(numbers[i]);
            temp = temp.next;
        }

        size = numbers.length;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void printList() {
        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
        System.out.println("Size: " + size);
        Node temp = head;
        while (temp != tail.next) {
            if (temp != tail) {
                System.out.print(temp.data + " -> ");
            } else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public Node removeLast() {
        if (size == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Node removeFirst() {
        if (size == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;

        if (size == 0) {
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.data = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > size) return false;
        if(index == 0) {
            prepend(value);
        } else if(index == size) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node temp = get(index - 1);
            if(temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        }
        return true;
    }

}
