package quicksort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * 双路快速排序
     */
    private int partition(E[] arr, int l, int r) {
        int p = l + ThreadLocalRandom.current().nextInt(r-l+1);
        swap(arr, l,p);

        // arr[l+1 ... i-1] <= v ; arr[j+1 ... r] >= v
        int i = l+1, j= r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if(i >= j) {
                break;
            }
            swap(arr, i , j);
            i++;
            j--;
        }
        swap(arr, l ,j);
        return j;


    }

    private int partitionOld(E[] arr, int l, int r) {
        // arr[ l+1 .. j] < v ; arr[j +1 ..i) >= v
        int p = l + ThreadLocalRandom.current().nextInt(r - l + 1);
        swap(arr, l, p);
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
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, 1);
        SortingHelper.sortTest(new QuickSort<>(), arr);

    }
}
