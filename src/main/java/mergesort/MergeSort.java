package mergesort;

import linearsearch.ArrayGenerator;
import selectionsort.InsertionSort;
import selectionsort.SelectionSort;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(new MergeSort<>(), arr);
        SortingHelper.sortTest(new SelectionSort<>(), arr2);
        SortingHelper.sortTest(new InsertionSort<>(), arr3);
    }

    @Override
    public void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length, temp );
    }

    /**
     * 对 arr[l,r) 范围进行排序
     */
    private void sort(E[] arr, int l, int r, E[] temp) {

        // 因为 r 是开区间，所以 r 比 l 多1时，整个数组只有一个元素
        if (l >= r - 1) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid, r, temp);
        merge(arr, l, mid, r, temp);
    }

    /**
     * 合并 arr[l, mid) 和 arr[mid, r)
     */
    private void merge(E[] arr, int l, int mid, int r, E[] aux) {
        System.arraycopy(arr, l, aux, l, r-l);

        int i = l, j = mid;
        // 每次循环为 arr[k] 赋值
        for (int k = l; k < r; k++) {
            // 当 i >= mid, 就不用管左侧数组了
            if (i >= mid) {
                arr[k] = aux[j];
                j++;
            } else if (j >= r) {
                // 当 j >=r， 就不用管右侧数组了
                arr[k] = aux[i];
                i++;
            }else if(aux[i].compareTo(aux[j] )<= 0){
                arr[k] = aux[i];
                i++;
            }else {
                arr[k] = aux[j];
                j++;
            }
        }
    }
}
