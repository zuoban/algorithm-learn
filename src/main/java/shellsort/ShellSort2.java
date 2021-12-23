package shellsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

import java.util.Arrays;

public class ShellSort2<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(new ShellSort<>(), arr2);
        SortingHelper.sortTest(new ShellSort2<>(), arr);
    }

    @Override
    public void sort(E[] data) {
        int h = data.length / 2;
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
            h /= 2;
        }
    }
}
