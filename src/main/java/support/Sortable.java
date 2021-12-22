package support;

public interface Sortable<E extends Comparable<E>> {
    void sort(E[] arr);

    default void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
