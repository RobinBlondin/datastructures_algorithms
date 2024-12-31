import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private final int size = 7;
    private final Node[] table;

    public static class Node {
        private final String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable() {
        this.table = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            Node current = table[i];
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(String.format("{ %s = %d }", current.key, current.value));
                if(current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            System.out.println(sb);
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % size;
        }
        return hash ;
    }

    public void set(String key, int value) {
        if (key == null) {
            return;
        }

        int index = hash(key);
        Node newNode = new Node(key, value);

        if(table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while(true) {
                if(current.key.equals(key)) {
                    current.value += value;
                    return;
                }
                if(current.next == null) {
                   break;
                }
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node current = table[index];

        while(current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return 0;
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (Node node : table) {
            Node current = node;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
}
