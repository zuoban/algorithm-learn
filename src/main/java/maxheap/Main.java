package maxheap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("add completed");

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        System.out.println("extract completed");
        for (int i = 1; i < n; i++) {
            if(arr[i-1] < arr[i]) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("Test MaxHeap completed");
    }
}
