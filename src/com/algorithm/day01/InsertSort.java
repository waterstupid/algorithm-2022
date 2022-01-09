package com.algorithm.day01;

import java.util.Arrays;

/**
 * 插入排序:
 * 0 - 0 有序  由 0 往 左看,如果左边的数比自己大,则进行交换,直到左边没有了元素
 * 0 - 1 有序  由 1 往 左看,如果左边的数比自己大,则进行交换,直到左边没有了元素
 * 0 - 2 有序  由 2 往 左看,如果左边的数比自己大,则进行交换,直到左边没有了元素
 * ...
 * 0 - N - 1 有序  由 N - 1 往左看,如果左边的数比自己大,则进行交换,直到左边没有了元素, 才停止搜寻
 * @author Fu Ming Kun
 */
public class InsertSort {

    public static void insertSort(int [] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1 ; i <= arr.length - 1 ; i++) {
            for (int j = i ; j > 0 ; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(j - 1, j, arr);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
            insertSort(copyArr);
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
     *
     * @param maxValue 指定数组的最大值
     * @param maxLength 指定数组的最大长度
     * @return 新数组
     */
    public static int[] generateRandomArray(int maxValue, int maxLength) {
        int [] arr = new int[maxLength];
        for (int i = 0 ; i < maxLength ; i++) {
            // [0 - 1) -> [0 - maxValue) -> [0 - maxValue - 1]
            arr[i] = (int) (Math.random() * maxValue) - (int)(Math.random() * maxValue);
        }
        return arr;
    }


}
