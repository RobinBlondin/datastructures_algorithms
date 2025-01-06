import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println(sort.bubbleSort());
        System.out.println(sort.selectionSort());
        System.out.println(sort.insertionSort());

        List<Integer> list = sort.generateRandomNumbers(20, 1, 100);
        System.out.println(list);
        System.out.println(sort.mergeSort(list));

        list = sort.generateRandomNumbers(5, 1, 100);
        System.out.println(list);
        sort.quickSort(list, 0, list.size() - 1);
        System.out.println(list);

    }
}