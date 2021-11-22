package quicksort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3Ways<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest(new QuickSort<>(), arr);
        SortingHelper.sortTest(new QuickSort2Ways<>(), arr2);
        SortingHelper.sortTest(new QuickSort3Ways<>(), arr3);

        System.out.println("Ordered Array");
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(new QuickSort<>(), arr);
        SortingHelper.sortTest(new QuickSort2Ways<>(), arr2);
        SortingHelper.sortTest(new QuickSort3Ways<>(), arr3);

        System.out.println("Same Value Array");
        arr = ArrayGenerator.generateRandomArray(n, 1);
//        SortingHelper.sortTest(new QuickSort<>(), arr);
        SortingHelper.sortTest(new QuickSort2Ways<>(), arr);
        SortingHelper.sortTest(new QuickSort3Ways<>(), arr);
    }

    @Override
    public void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = l + ThreadLocalRandom.current().nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[ l+1, lt] < v, arr[lt + 1, i -1] == v,  arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                // arr[i] == arr[l]
                i++;
            }
        }
        swap(arr, l, lt);
        // arr[l, lt-1] < v, arr[lt, gt-1] == v, arr[gt, r] > v
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    private void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
