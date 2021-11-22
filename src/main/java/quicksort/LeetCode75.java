package quicksort;

import java.util.Arrays;

/**
 * 颜色分类
 */
public class LeetCode75 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        new LeetCode75().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int l = -1, i = 0, r = nums.length;
        while(i < r) {
            if(nums[i] == 0) {
                l++;
                swap(nums, l, i);
                i++;
            }else if (nums[i] == 2) {
                r--;
                swap(nums, r, i);
            }else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
