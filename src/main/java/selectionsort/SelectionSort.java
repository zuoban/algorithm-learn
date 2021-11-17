package selectionsort;

import java.util.Arrays;

public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 6, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

