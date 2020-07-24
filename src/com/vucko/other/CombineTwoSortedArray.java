package com.vucko.other;

import java.util.Arrays;

/**
 * 合并两个已经排好序的数组
 * @author zhangpeipei
 * @date 2020/7/24 17:18
 */
public class CombineTwoSortedArray {

    public static void main(String[] args) {

        int[] a = {5, 8, 9};
        int[] b = {4, 7, 8};
        //int[] c = combine(a, b);
        //int[] c = combine(b, a);

        System.out.println(Arrays.toString(combine(b, a)));
        System.out.println(Arrays.toString(combine(a, b)));
    }

    private static int[] combine(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                c[k++] = b[j];
                j++;
            } else {
                c[k++] = a[i++];
                c[k++] = b[j++];
            }
        }

        while(i < a.length){
            c[k++] = a[i++];
        }

        while(j < b.length){
            c[k++] = b[j++];
        }

        return c;
    }

}
