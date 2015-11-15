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
     * 分割数组
     * @param arr 需要排序的数组
     * @param start 被分割的那个分组的起点
     * @param end 被分割的那个分组的末端
     */
    public void divide(int[] arr, int start, int end) {

        /**
         * 如果当前的分组了内只有一元素或者有两个元素，那么我们排序好了之后返回
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
         * 如果分组的长度大于1，那就继续分组，
         * 根据待排数组的长度，mid 的值略有不同
         *
         */
        int mid = -1;
        if ((end + start) % 2 != 0) {
            mid = (int) Math.floor((end + start) >> 1);
        } else {
            mid = (end + start) >> 1;
        }

        // 递归调用分组
        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        //分完组之后开始合并
        merge(arr, start, mid, end);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    /**
     * 合并两个分组（合并的写法有点繁琐，应该是可以继续优化的）
     * @param arr 需要排序的数组
     * @param start 第一个分组的起点
     * @param mid 第一个分组的末端，第二个分组的起点是 mid + 1
     * @param end 第二个分组的末端
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
