public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(99);
        heap.insert(98);
        heap.insert(72);
        heap.insert(73);
        heap.insert(74);
        heap.insert(100);
        heap.insert(34);
        System.out.println(heap.getMinHeap());

        heap.remove();

        System.out.println(heap.getMinHeap());
        heap.remove();
        System.out.println(heap.getMinHeap());
    }
}