package com.learn.algorithm;


/**
 * @author: luzhiqing
 * @date: 2021/2/23
 * @version:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] datas = new int[]{3, 4, 0, 7, 8, 5, 4, 3, 4, 2};
        quickSort(datas, 0, datas.length - 1);
        for (int data : datas) {
            System.out.println(data);
        }
    }

    /**
     * 挖坑法
     *
     * @param datas
     * @param start
     * @param end
     * @return
     */
    public static void quickSort(int[] datas, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = datas[start];
        while (i < j) {
            while (i < j && datas[j] >= temp) {
                j--;
            }
            datas[i] = datas[j];
            while (i < j && datas[i] <= temp) {
                i++;
            }
            datas[j] = datas[i];
        }
        datas[i] = temp;
        quickSort(datas, i + 1, end);
        quickSort(datas, start, i - 1);
    }

}
