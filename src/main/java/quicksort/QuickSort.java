package quicksort;

import linearsearch.ArrayGenerator;
import mergesort.MergeSort;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class QuickSort<E extends Comparable<E>> implements Sortable<E> {
    @Override
    public void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(E[] arr, int l, int r) {
        // arr[ l+1 .. j] < v ; arr[j +1 ..i) >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 5000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(new MergeSort<>(), arr);
        SortingHelper.sortTest(new QuickSort<>(), arr2);


        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(new MergeSort<>(), arr);
        SortingHelper.sortTest(new QuickSort<>(), arr2);
    }
}
