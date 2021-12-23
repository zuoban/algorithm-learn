package shellsort;

import linearsearch.ArrayGenerator;
import support.Sortable;
import util.SortingHelper;

public class ShellSort<E extends Comparable<E>> implements Sortable<E> {
    public static void main(String[] args) {
        int n = 100000;
        SortingHelper.sortTest(new ShellSort<>(), ArrayGenerator.generateRandomArray(n, n));
    }

    @Override
    public void sort(E[] data) {
        int h = data.length / 2;
        while (h > 0) {
            for (int start = 0; start < h; start++) {
                // 对以 start 为起始，间隔为 h 的数组进行插入排序
                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }
            h /= 2;
        }
    }
}
