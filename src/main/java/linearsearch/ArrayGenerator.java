package linearsearch;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {

    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generateRandomArray(int length, int bound) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
