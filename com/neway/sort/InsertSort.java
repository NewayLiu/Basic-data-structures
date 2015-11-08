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
            int cache = arr[i]; //���浱ǰ��ֵ

            //��ǰ���ź���������м��ҵ���һ�����ڵ�ǰ���ֵģ�����λ�þ��ǵ�ǰ����Ӧ���ڵ�λ�á�
            for (int m = 0; m < i; m++) {
                if (arr[i] < arr[m]) {
                    insertPosition = m;
                    break;
                }
            }

            //����ҵ����ˣ��Ͱ��������������ƶ�һλ��
            if (insertPosition != -1) {
                for (int j = i; j > insertPosition && insertPosition != -1; j--) {
                    arr[j] = arr[j - 1];
                }
                // �ѵ�ǰ���ַŵ��ڳ�����λ����ȥ��
                arr[insertPosition] = cache;
            }

            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();

        }
    }
}
