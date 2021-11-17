package selectionsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class InsertionSort<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("Random  Array :");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(new InsertionSort<>(), arr);
            SortingHelper.sortTest(new SelectionSort<>(), arr2);

            System.out.println("Sorted Array: ");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(new InsertionSort<>(), arr);
            SortingHelper.sortTest(new SelectionSort<>(), arr2);

        }
    }

    @Override
    public void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
}
