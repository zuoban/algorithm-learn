package shellsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class ShellSort3<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(new ShellSort2<>(), arr);
        SortingHelper.sortTest(new ShellSort3<>(), arr2);
    }

    @Override
    public void sort(E[] data) {
        int h = 1;
        while (h < data.length) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            // 对以 start 为起始，间隔为 h 的数组进行插入排序
            for (int i = h; i < data.length; i++) {
                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }
            h /= 3;
        }
    }
}
