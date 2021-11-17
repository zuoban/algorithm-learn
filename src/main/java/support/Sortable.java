package support;

public interface Sortable<E extends Comparable<E>> {
    void sort(E[] arr);
}
