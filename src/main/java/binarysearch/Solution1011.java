package binarysearch;

import java.util.Arrays;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (days(weights, mid) <= days) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int days(int[] weights, int k) {
        int cur = 0, res = 0;
        for (int weight : weights) {
            if(cur + weight <= k) {
                cur += weight;
            }else {
                res ++;
                cur = weight;
            }
        }
       res++;
        return res;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new Solution1011().days(weights, 14));
    }

}
