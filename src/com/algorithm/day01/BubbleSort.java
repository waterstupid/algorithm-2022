package com.algorithm.day01;

import java.util.Arrays;

/**
 * 冒泡排序:
 * 冒泡排序的关键点就在于‘冒泡’这两个字，因为这个算法流程就好像冒泡一样，这里遵循从小 -> 大 这种规则排序,首先分析一下这个算法的总
 * 流程,首先,还是只有 N 个 数字,下标从 0 - N - 1开始,也就是让0 和 1 上的元素两两比较，谁大谁往后挪,然后再让1和2位置上的元素两两相比较，
 * 谁大谁往后挪，知道N - 2 和 N - 1上的元素两两比较完毕之后，但是经过一轮比较并不能将整个数组排好序，假设有三个元素 a b c, a > b ,所以
 * a往后挪,这个时候a > c , a再往后挪,虽然 b c两个元素都比a小,但是并不知道b c两个元素之间的大小关系,所以要再比较一次！
 *
 * 算法流程:
 * 假设有N个元素,下标为 0 - N - 1
 * 0 -  N - 1  两两比较,谁大谁往后移,比较完毕之后,可以确定N - 1这个位置上的元素，是整个0 - N - 1上最大的元素
 * 0 -  N - 2  两两比较,谁大谁往后移,比较完毕之后,可以确定N - 2这个位置上的元素，是整个0 - N - 2上最大的元素
 * ....
 * 0 - 1       两两比较,谁大谁往后移,比较完毕之后,可以确定2这个位置上的元素，是整个0 - 1上最大的元素
 *
 * 经过上面这样的流程,比较就结束了, 所以一共要经过N - 1这样的比较次数
 *
 * @author Fu Ming Kun
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 指定要排序的数组
     */
    public static void bubbleSort(int [] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 外层控制流程中会变的东西
        for (int i = arr.length - 1 ; i >= 1 ; i--) {
            // 内层控制流程中不会变得数字
            for (int j = 0 ; j <= i - 1 ; j++) {
                // 两两交换 谁大往后移
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
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
            bubbleSort(copyArr);
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
    private static int[] generateRandomArray(int maxValue, int maxLength) {
        int [] arr = new int[maxLength];
        for (int i = 0 ; i < maxLength ; i++) {
            // [0 - 1) -> [0 - maxValue) -> [0 - maxValue - 1]
            arr[i] = (int) (Math.random() * maxValue) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

}
