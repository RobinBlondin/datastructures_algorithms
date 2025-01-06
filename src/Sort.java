import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort {

    public List<Integer> generateRandomNumbers(int size, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }
        return numbers;
    }

    public List<Integer> bubbleSort() {
        List<Integer> numbers = generateRandomNumbers(10, 1, 100);

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(j) < numbers.get(i)) {
                    Collections.swap(numbers, i, j);
                }
            }
        }
        return numbers;
    }

    public List<Integer> selectionSort() {
        List<Integer> numbers = generateRandomNumbers(15, 100, 1000);

        for (int i = 0; i < numbers.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(j) < numbers.get(minIndex)) {
                    minIndex = j;
                }
            }
            Collections.swap(numbers, i, minIndex);
        }
        return numbers;
    }

    public List<Integer> insertionSort() {
        List<Integer> numbers = generateRandomNumbers(10, 100, 1000);

        for (int i = 0; i < numbers.size() - 1; i++) {
            int pointer = i + 1;
            if(numbers.get(pointer) < numbers.get(i)) {
                for(int j = i; j >= 0; j--) {
                    if(numbers.get(pointer) < numbers.get(j)) {
                        Collections.swap(numbers, pointer, j);
                        pointer = j;
                    } else {
                        break;
                    }
                }
            }
        }
        return numbers;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        if(i < left.size()) {
            merged.addAll(left.subList(i, left.size()));
        }

        if(j < right.size()) {
            merged.addAll(right.subList(j, right.size()));
        }
        return merged;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        if(list.size() <= 1) {
            return list;
        }

        List<Integer> left = mergeSort(list.subList(0, list.size() / 2));
        List<Integer> right = mergeSort(list.subList(list.size() / 2, list.size()));

        return merge(left, right);
    }

    private int pivot(List<Integer> list, int startIndex, int endIndex) {
        int swap = startIndex;

        for(int i = startIndex + 1; i <= endIndex; i++) {
            if(list.get(i) < list.get(startIndex)) {
                swap++;
                Collections.swap(list, i, swap);
            }
        }
        Collections.swap(list, swap, startIndex);
        return swap;
    }

    public void quickSort(List<Integer> list, int left, int right) {
        if(left < right) {
            int pivot = pivot(list, left, right);

            quickSort(list, 0, pivot - 1);
            quickSort(list, pivot + 1, right);
        }

    }
}
