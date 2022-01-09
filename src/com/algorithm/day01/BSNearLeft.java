package com.algorithm.day01;

/**
 * 有序数组中找到>=num最左的位置
 * 二分法是一定能够在一个有序数组中明确的知道是否找到了某个元素
 * @author Fu Ming Kun
 */
public class BSNearLeft {

    public static int bsNearLeft(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                // 在找到的时候作文章(这种写法 不够巧妙)
                int i;
                for (i = mid - 1; i >= 0 ; i--) {
                    if (arr[i] < target) {
                        break;
                    }
                }
                return i + 1;
            } else if (arr[mid] > target) {
                R = mid- 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == target ? L : -1;
    }

    public static int bsNearLeft1(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= target) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == target ? Math.min(L, index) : index;
    }





}
