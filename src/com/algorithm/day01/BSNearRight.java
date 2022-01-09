package com.algorithm.day01;

/**
 * 有序数组中找到<=num最右的位置
 *
 * @author Fu Ming Kun
 */
public class BSNearRight {

    public static int bsNearRight(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int mid;
        int index = -1;
        int L = 0;
        int R = arr.length - 1;
        while(L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] <= target) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

}
