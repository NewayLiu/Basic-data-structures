package com.neway.sort;

/**
 * Created by Neway on 2015/11/9.
 */
public class BinarySearch {

    public int binarySearch(int arr[], int destination) {

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) >> 1;

        while (right >= left) {
            if (arr[mid] == destination) {
                return mid;
            } else if (arr[mid] > destination) {
                right = mid - 1;
                mid = (left + right) >> 1;
            } else {
                left = mid + 1;
                mid = (left + right) >> 1;
            }

        }
        return -1;
    }
}
