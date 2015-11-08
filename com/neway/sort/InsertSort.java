package com.neway.sort;

/**
 * Created by Neway on 2015/11/1.
 */
public class InsertSort implements Sort {

    public static void main(String[] s) {
        Sort sort = new InsertSort();
        int arr[] = {-12, 5, 6, -5, -5, 569, 125, -58, 9, 36};
        sort.sort(arr);
    }


    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertPosition = -1;
            int cache = arr[i]; //缓存当前的值

            //从前面排好序的数字中间找到第一个大于当前数字的，它的位置就是当前数字应该在的位置。
            for (int m = 0; m < i; m++) {
                if (arr[i] < arr[m]) {
                    insertPosition = m;
                    break;
                }
            }

            //如果找到了了，就把数字依次往后移动一位。
            if (insertPosition != -1) {
                for (int j = i; j > insertPosition && insertPosition != -1; j--) {
                    arr[j] = arr[j - 1];
                }
                // 把当前数字放到腾出来的位置上去。
                arr[insertPosition] = cache;
            }

            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();

        }
    }
}
