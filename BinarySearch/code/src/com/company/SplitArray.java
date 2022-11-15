package com.company;

/*
        https://leetcode.com/problems/split-array-largest-sum/
        Date : 10 Sep 2022
*/
public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,8,10};
        int m = 2;
        int ans = splitArray(arr,m);
        System.out.println(ans);
    }
    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end  = 0;
        for(int i=0; i< nums.length;i++){
            start = Math.max(start, nums[i]); // this will give you the max element at the end of the loop
            end += nums[i]; // sum of the values in the entire array
        }
        //we have got the start and end

        while(start < end){
            int sum = 0;
            int pieces = 1;
            int mid = start + (end-start)/2;
            for(int num : nums){
                if(num + sum > mid){
                    sum = num;
                    pieces++;
                } else {
                    sum+=num;
                }
            }
            if(pieces > m){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
