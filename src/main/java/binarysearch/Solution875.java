package binarysearch;

import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 */
public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int eatingTime(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + k - 1) / k;
        }
        return sum;
    }

}