package bubblesort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

public class BubbleSort<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 10000;
        SortingHelper.sortTest(new BubbleSort<>(), ArrayGenerator.generateRandomArray(n, n));
        SortingHelper.sortTest(new BubbleSort<>(), ArrayGenerator.generateOrderedArray(n));
    }

    @Override
    public void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = arr.length - lastSwappedIndex;
        }
    }
}
