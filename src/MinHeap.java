import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap {
    private final List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<Integer>();
    }

    public List<Integer> getMinHeap() {
        return new ArrayList<>(heap);
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        Collections.swap(heap, index1, index2);
    }

    public void insert(int value) {
        heap.add(value);

        int current = heap.size() - 1;
        while(current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void sinkDown(int index) {
        int minIndex = index;
        while(true) {
            int left = leftChild(minIndex);
            int right = rightChild(minIndex);

            if(left < heap.size() && heap.get(left) < heap.get(minIndex)) {
                minIndex = left;
            }

            if(right < heap.size() && heap.get(right) < heap.get(minIndex)) {
                minIndex = right;
            }

            if(minIndex != index) {
                swap(minIndex, index);
                index = minIndex;
            } else {
                break;
            }
        }
    }

    public Integer remove() {
        if(heap.isEmpty()) {
            return null;
        }

        if(heap.size() == 1) {
            return heap.removeFirst();
        }

        int min = heap.getFirst();
        heap.set(0, heap.removeLast());
        sinkDown(0);
        return min;
    }

}
