package com.neway.sort;

/**
 * Created by Neway on 2015/11/15.
 */
public class MergeSort implements Sort {


    public static void main(String args[]) {
        Sort sort = new MergeSort();
        int arr[] = {89, 78, 8, 5, 13, 12, 11, 1, 0};
        sort.sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    /**
     * �ָ�����
     * @param arr ��Ҫ���������
     * @param start ���ָ���Ǹ���������
     * @param end ���ָ���Ǹ������ĩ��
     */
    public void divide(int[] arr, int start, int end) {

        /**
         * �����ǰ�ķ�������ֻ��һԪ�ػ���������Ԫ�أ���ô�����������֮�󷵻�
         */
        if (start == end || end - start == 1) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            return;
        }

        /**
         * �������ĳ��ȴ���1���Ǿͼ������飬
         * ���ݴ�������ĳ��ȣ�mid ��ֵ���в�ͬ
         *
         */
        int mid = -1;
        if ((end + start) % 2 != 0) {
            mid = (int) Math.floor((end + start) >> 1);
        } else {
            mid = (end + start) >> 1;
        }

        // �ݹ���÷���
        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        //������֮��ʼ�ϲ�
        merge(arr, start, mid, end);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    /**
     * �ϲ��������飨�ϲ���д���е㷱����Ӧ���ǿ��Լ����Ż��ģ�
     * @param arr ��Ҫ���������
     * @param start ��һ����������
     * @param mid ��һ�������ĩ�ˣ��ڶ������������� mid + 1
     * @param end �ڶ��������ĩ��
     */
    public void merge(int[] arr, int start, int mid, int end) {
        int startCopy = start;
        int midCopy = mid;
        int[] arrCopy = new int[end - start + 1];
        int index = 0;
        while (start <= midCopy && (mid + 1) <= end) {
            if (arr[start] < arr[mid + 1]) {
                arrCopy[index++] = arr[start];
                start++;
            } else {
                arrCopy[index++] = arr[mid + 1];
                mid++;
            }
        }

        while (start <= midCopy) {
            arrCopy[index++] = arr[start++];
        }

        while ((mid + 1) <= end) {
            arrCopy[index++] = arr[mid + 1];
            mid++;
        }

        for (int i = 0; i < arrCopy.length; i++) {
            arr[startCopy++] = arrCopy[i];
        }
    }

}
