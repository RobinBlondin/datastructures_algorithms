import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    private final List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
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

        while(current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(parent(current), current);
            current = parent(current);
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.getFirst();
        }

        int max = heap.getFirst();
        heap.set(0, heap.removeLast());
        sinkDown(0);

        return max;
    }

    public void sinkDown(int index) {
        int maxIndex = index;

        while(true) {
            int left = leftChild(index);
            int right = rightChild(index);

            if(left < heap.size() && heap.get(left) > heap.get(maxIndex)) {
                maxIndex = left;
            }

            if(right < heap.size() && heap.get(right) > heap.get(maxIndex)) {
                maxIndex = right;
            }

            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }


}
