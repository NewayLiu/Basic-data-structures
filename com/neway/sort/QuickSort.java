package com.neway.sort;

/**
 * Created by Neway on 2015/11/21.
 */
public class QuickSort implements Sort {

    public static void main(String args[]) {
        int arr[] = {11,8,-12,-7, 5, 6, -5, 569, -5,1,2,3125, -58,-9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        //System.out.println(quickSort.getPivot(arr, 0, arr.length - 1));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = getPivot(arr, left, right);
        int i = left + 1;
        int l = right - 2;
        while (i <= l) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[l] > pivot) {
                l--;
            }

            if (i < l) {
                swap(arr, i, l);
            } else {
                swap(arr, i, right - 1);
                break;
            }

        }

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

    }

    /**
     * 采取首中尾的方式来获取主元
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getPivot(int[] arr, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[start] > arr[mid]) {
                swap(arr, start, mid);
            }

            if (arr[start] > arr[end]) {
                swap(arr, start, end);
            }

            if (arr[end] < arr[mid]) {
                swap(arr, end, mid);
            }
            swap(arr, end - 1, mid);

            return arr[end - 1];
        }
        return arr[start];
    }

    private static void swap(int[] arr, int m, int n) {
        int i = arr[m];
        arr[m] = arr[n];
        arr[n] = i;
    }
}
