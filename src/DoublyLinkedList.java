
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoublyLinkedList(int... numbers) {
        head = new Node(numbers[0]);
        Node prev = null;
        Node temp = head;

        for (int i = 1; i < numbers.length; i++) {
            temp.next = new Node(numbers[i]);
            temp.prev = prev;
            prev = temp;
            temp = temp.next;
        }
        tail = temp;
        tail.prev = prev;
        size = numbers.length;
    }


    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printAsc() {
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
        System.out.println();
    }

    public void printDesc() {
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
        System.out.println("Size: " + size);
        Node temp = tail;
        while (temp != null) {
            if (temp.prev != null) {
                System.out.print(temp.value + " -> ");
            } else {
                System.out.print(temp.value);
            }
            temp = temp.prev;
        }
        System.out.println();
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node temp = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            newNode.next = temp;
            temp.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public Node removeFirst() {
        if (size == 0) {
            return null;
        }

        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp;

        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node temp = get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }

        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node temp = get(index);

            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            newNode.next = temp;
            newNode.next.prev = newNode;
            size++;
        }
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        size--;
        return temp;
    }


}
