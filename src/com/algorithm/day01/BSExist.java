package com.algorithm.day01;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.algorithm.day01.InsertSort.generateRandomArray;

/**
 * 二分法查找: 如果需要在一个有序数组查找某个元素，这是个很简单的做法，做法有很多种，比如，遍历一个数组，查找数组中是否存在这个元素，
 * 但是这样的做法的复杂度O(n),所以我们可以使用二分法,算法流程如下:
 * 此时有N个元素，下标为0...N - 1，分为左右两个指针,左指针从下标为0的元素开始，右指针从下标为N - 1的元素开始，然后找到 (0 + N - 1) /  2
 * 这个mid这个位置上的元素,如果arr[mid]  > target,那么说明指针要往左移动,因为mid位置右边的元素一定是大于target的,重复这个过程,直到找到目标
 * 元素为止！！！
 *
 * @author Fu Ming Kun
 */
public class BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R
        while (L <= R) { // L..R 至少两个数的时候
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    public static boolean binarySearch(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l < r) { // l 和 r 至少两个数的时候
            // (r + l) / 2 有可能越界的 因为两个int类型的数据进行相加,那么就有可能超出这个精度的范围
            // 但是 r / 2 + l / 2 这个是不会超出精度
            // 所以使用位运算 位运算的效率明显比普通的算术运算符高
            mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                // 向左移动
                r = mid - 1;
            }else {
                // 向右移动
                l = mid + 1;
            }
        }
        return arr[l] == target;
    }

    // for test
    public static boolean test(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int times = 100000000;
        int maxValue = 20;
        int maxLength = 10;
        System.out.println("test begin.....");
        for (int i = 0 ; i < times; i++) {
            int [] randomArr = generateRandomArray(maxValue, maxLength);
            Arrays.sort(randomArr);
            int target = (int) (Math.random() * maxLength);
            boolean flag1 = binarySearch(randomArr, target);
            boolean flag2 = exist(randomArr, target);
            if (!equals(flag1, flag2)) {
                System.out.println("fuck....");
                System.out.println(Arrays.toString(randomArr));
                System.out.println(target);
                System.out.println(flag1);
                System.out.println(flag2);
                break;
            }
        }
        System.out.println("test end......");
    }

    private static boolean equals(boolean flag1, boolean flag2) {
        return (flag1 && flag2) || (!flag1 && !flag2);
    }


}
