package maxheap;

import support.Sortable;

public class HeapSort2<E extends Comparable<E>> implements Sortable<E> {
    @Override
    public void sort(E[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            shiftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            shiftDown(data, 0, i);
        }
    }

    /**
     * 对 data[0, n) 所形成的最大堆中，索引 k 的元素，执行 shiftDown
     */
    private void shiftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void swap(E[] data, int k, int j) {
        E t = data[k];
        data[k] = data[j];
        data[j] = t;
    }
}
