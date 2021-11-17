package selectionsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

public class InsertionSort<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(new InsertionSort<>(), arr);
        }
    }

    @Override
    public void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }

    }

    private void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
