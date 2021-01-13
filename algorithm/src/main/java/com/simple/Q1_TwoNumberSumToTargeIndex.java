package com.simple;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * leetCode  question 1 ：  两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 2 <= nums.length <= 1000
 * -109 <= nums[i] <= 10的9次
 * -109 <= target <= 10的9次
 */

public class Q1_TwoNumberSumToTargeIndex {

    public static void main(String[] args) {
        Q1_TwoNumberSumToTargeIndex TwoNumberSumToTargeIndex = new Q1_TwoNumberSumToTargeIndex();
        int[] nums = {2,7,11,15};
        int target = 9;
        //暴力破解
        System.out.println(JSONArray.toJSONString(TwoNumberSumToTargeIndex.twoSum(nums,target)));
        //hash 破解
        System.out.println(JSONArray.toJSONString(TwoNumberSumToTargeIndex.twoSumFroHash(nums,target)));
    }

    //solution 1：暴力 双循环    O（n2）  空间O(1)

    public int[] twoSum(int[] nums, int target) {
        long  start  = System.nanoTime();//系统时钟 纳秒
        if(nums == null || nums.length<2 || nums.length>1000){
           return new int[0];
        }
        int[] result = new int[2];
        for (int i = 0; i <nums.length ; i++) {
            int one = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                int two = nums[j];
                if(one + two ==target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        long  end  = System.nanoTime();

        System.out.println("时间纳秒："+((end-start)));
        return result;

    }


    //solution 2：HashMap 采用 单循环  进入Hash的方式  时间O(n)  空间O(n)

    public int[] twoSumFroHash(int[] nums, int target) {
        long  start  = System.nanoTime();//系统时钟 纳秒
        if(nums == null || nums.length<2 || nums.length>1000){
            return new int[0];
        }
        int[] result = new int[2];
        Map<Integer,Integer> hash = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {

           if(hash.containsKey(target-nums[i])){
               result[0]=hash.get(target-nums[i]);
               result[1] = i;

           }

            hash.put(nums[i],i);
        }

        long  end  = System.nanoTime();

        System.out.println(end-start);
        return result;

    }






}
