package quicksort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组中的第K个最大元素
 */
public class LeetCode215 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 0};
        int kthLargest = new LeetCode215().findKthLargest(arr, 3);
        System.out.println(kthLargest);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length, nums.length - k);
    }

    /**
     *  在 arr[l,r) 中寻找第k个元素
     */
    private int selectK(int[] arr, int l, int r, int k) {
        int p = partition(arr, l, r - 1);
        if (k == p) {
            return p;
        } else if (k < p) {
            return selectK(arr, l, p, k);
        } else {
            return selectK(arr, p + 1, r, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int p = l + ThreadLocalRandom.current().nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[l + 1 ... i-1] <= v; arr[j + 1 ... r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            while (i <= j && arr[j] > arr[l]) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;

    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
