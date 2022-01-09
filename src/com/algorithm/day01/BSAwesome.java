package com.algorithm.day01;

/**
 * 局部最小值问题
 * 定义何为局部最小值：
 * arr[0] < arr[1]，0位置是局部最小；
 * arr[N-1] < arr[N-2]，N-1位置是局部最小；
 * arr[i-1] > arr[i] < arr[i+1]，i位置是局部最小；
 * 给定一个数组arr，已知任何两个相邻的数都不相等，找到随便一个局部最小位置返回
 *
 * @author Fu Ming Kun
 */
public class BSAwesome {

    public static int bsAweSome(int [] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 2] > arr[N - 1]) {
            return N - 1;
        }
        int L = 1;
        int R = N - 2;
        while ( L < R ) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        // 因为一定存在一个局部最小 所以返回最后一个元素
        return L;
    }


}
