package maxheap;

import linearsearch.ArrayGenerator;
import mergesort.MergeSort;
import quicksort.QuickSort2Ways;
import quicksort.QuickSort3Ways;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class HeapSort<E extends Comparable<E>> implements Sortable<E> {
    @Override
    public void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E datum : data) {
            maxHeap.add(datum);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);


        SortingHelper.sortTest(new HeapSort<>(), arr);
        SortingHelper.sortTest(new MergeSort<>(), arr2);
        SortingHelper.sortTest(new QuickSort2Ways<>(), arr3);
        SortingHelper.sortTest(new QuickSort3Ways<>(), arr4);
        SortingHelper.sortTest(new HeapSort2<>(), arr5);

    }
}
