package com.vucko.lt0001;

import java.util.Arrays;

/**
 *
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author zhangpeipei
 * @date 2020/7/7 13:01
 */
public class FindArrIndex {


    public static void main(String[] args) {
        int[] arr = {2,4,2,4,5,32,6,8};
        int target = 9;
        int[] res = getIndex(arr, target);
        System.out.println(Arrays.toString(res));
    }
    
    private static int[] getIndex(int[] nums, int target){
        int length = nums.length;
        if(length <=1)
            return null;
        
        int i,j;
        for (i = 0; i < length-1; i++) {
            int a = nums[i];
            for (j = i+1; j < length; j++) {
                int b = nums[j];
                if(a + b == target){
                    return new int[]{i,j};
                }

            }
        }

        return null;
    }
}
