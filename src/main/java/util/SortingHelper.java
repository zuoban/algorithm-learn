package util;

import support.Sortable;

public class SortingHelper {
    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(Sortable<E> sortable, E[] arr) {
        String sortName = sortable.getClass().getSimpleName();
        long startTime = System.nanoTime();
        sortable.sort(arr);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!isSorted(arr)) {
            throw new RuntimeException(sortName + " sort fail");
        }
        System.out.printf("%s, n = %d : %fs%n", sortName, arr.length, time);
    }
}
