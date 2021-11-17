package selectionsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

public class SelectionSort<E extends Comparable<E>> implements Sortable<E> {
    private SelectionSort() {
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(new SelectionSort<>(), arr);
        }
    }

    @Override
    public void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}

