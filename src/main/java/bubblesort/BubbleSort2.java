package bubblesort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

public class BubbleSort2<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 10000;
        SortingHelper.sortTest(new BubbleSort2<>(), ArrayGenerator.generateRandomArray(n, n));
        SortingHelper.sortTest(new BubbleSort2<>(), ArrayGenerator.generateOrderedArray(n));
    }

    @Override
    public void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int lastSwappedIndex = arr.length - 1;
            for (int j = arr.length - 1; j > 0 ; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j , j - 1);
                    lastSwappedIndex = j -1;
                }
            }
            i = lastSwappedIndex;
        }
    }
}
