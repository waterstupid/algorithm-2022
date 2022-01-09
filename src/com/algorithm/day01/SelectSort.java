package com.algorithm.day01;

import java.util.Arrays;

/**
 * 选择排序:
 * 选择排序的关键点在于‘选择’这两字
 * 所谓选择就是说:如果现在有N个数字，它的下标为0 - N - 1 ,那么就有以下算法流程
 * 0 - N - 1 上找出最小值,将这个最小值和0位置上的数字进行交换
 * 1 - N - 1 上找出最小值,将这个最小值和1位置上的数字进行交换
 * 2 - N - 1 上找出最小值,将这个最小值和2位置上的数字进行交换
 * ....
 * N-2 - N - 1上找出最小值，将这个最小值和N-1位置上的数字进行交换
 * <p>
 * 综上所诉:一共是经过 N - 1次的找最小值和比较才完成整个流程
 * 所以时间复杂度就是所谓的O(n2)
 *
 * @author Fu Ming Kun
 */
public class SelectSort {

    /**
     * 选择排序
     * @param arr 需要排序的数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 最外层循环控制0...N-1 1...N-1 2....N-1
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 内层循环控制 找最小值和交换这件事情 每次都从i + 1开始寻找
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(arr[j], arr[min]) == arr[j] ? j : min;
            }
            // 交换
            swap(i, min, arr);
        }
    }

    public static void main(String[] args) {
        int times = 10000;
        int maxValue = 20;
        int maxLength = 10;
        System.out.println("test begin.....");
        for (int i = 0 ; i < times; i++) {
            int [] randomArr = generateRandomArray(maxValue, maxLength);
            int[] copyArr = Arrays.copyOf(randomArr, maxLength);
            Arrays.sort(randomArr);
            selectSort(copyArr);
            if (!Arrays.equals(randomArr, copyArr)) {
                System.out.println("fuck....");
                System.out.println(Arrays.toString(copyArr));
                System.out.println(Arrays.toString(randomArr));
                break;
            }
        }
        System.out.println("test end......");

    }

    /**
     * 该方法用于随机生成一个数组
     * @param maxValue 指定数组的最大值
     * @param maxLength 指定数组的最大长度
     * @return 新数组
     */
    private static int[] generateRandomArray(int maxValue, int maxLength) {
        int [] arr = new int[maxLength];
        for (int i = 0 ; i < maxLength ; i++) {
            // [0 - 1) -> [0 - maxValue) -> [0 - maxValue - 1]
            arr[i] = (int) (Math.random() * maxValue) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
