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
        Node temp = head;

        for (int i = 1; i < numbers.length; i++) {
            temp.next = new Node(numbers[i]);
            temp = temp.next;
        }
        tail = temp;
        size = numbers.length;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
        System.out.println("Size: " + size);
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.value + " -> ");
            } else {
                System.out.print(temp.value);
            }
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
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

    public void prepend(int value) {
        Node newNode = new Node(value);
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
            temp.value = value;
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

    public Node remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if(index == 0) {
            return removeFirst();
        }

        if(index == size - 1) {
            return removeLast();
        }

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        size--;

        return temp;
    }

    public void reverse() {
        if (head == null || tail == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

}
