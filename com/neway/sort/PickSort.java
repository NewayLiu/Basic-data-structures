package com.neway.sort;

import java.util.ArrayList;

/**
 * Created by Neway on 2015/11/7.
 */
public class PickSort implements Sort {


    /**
     * ÿ�δӴ������������ѡ��һ����С��ֵ�����ź�������������
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {

        int minValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;


            for (int m : arr) {
                System.out.print((m) + "  ");
            }

            System.out.println();
        }
    }
}
