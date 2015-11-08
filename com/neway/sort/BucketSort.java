package com.neway.sort;

import java.util.ArrayList;

/**
 * Created by Neway on 2015/10/21.
 */
public class BucketSort implements Sort{
    public static void main(String[] s) {
        Sort sort = new BucketSort();
        int arr [] = {-12,5,6,98,-5,569,125,-58,9,36};
        sort.sort(arr);
    }

    @Override
    public void sort(int[] array) {
        ArrayList<Integer> buckets [] = new ArrayList[10];
        for(int i = 0; i < 10 ;i++) {
            buckets[i] = new ArrayList<>();
        }

        int LSDTimes = String.valueOf(getMax(array)).length();
        for(int lsdTime = LSDTimes - 1; lsdTime > -1; lsdTime-- ) {
            for(int i = 0; i < array.length ; i++){
                    array[i] += 100;
                    //将数位补齐
                    String numStr = String.format("%0"+LSDTimes + "d",array[i]);
                    int num = numStr.charAt(lsdTime) - 48; //0 和 '0' 的ASCII码值相差 48。
                    // 将数字放入相应的桶中
                    buckets[num % 10].add(Integer.valueOf(array[i]));

                    // 将数字从上一个桶中移除掉。
                    if(lsdTime != LSDTimes - 1) {
                        int preNum = numStr.charAt(lsdTime + 1) - 48;
                        if(buckets[preNum % 10].contains(Integer.valueOf(array[i]))) {
                            buckets[preNum % 10].remove(Integer.valueOf(array[i]));
                        }
                    }
            }

            int index = 0;
            /**
             * 将桶中现在的数字赋值给数组，每次排序都是基于上个数位
             * 已经排好的顺序来进行的。
             */
            for(ArrayList<Integer> arrayList : buckets) {
                for(int i : arrayList) {
                    System.out.print((i - 100) + "  ");
                    array[index] = (i - 100);
                    index++;
                }
            }
            System.out.println();
        }
    }

    /**
     * 获取最大的数字，主要是为了获取LSD(Least Significant Digit)
     * 需要遍历的次数，说白了就是最大的数位是多长。
     * @param arr
     * @return
     */
    public int getMax(int arr[]) {
        int max = 0;
        for(int i : arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }
}
