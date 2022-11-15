package com.company;
/*
        https://leetcode.com/problems/missing-number/submissions/
        asked in amazon
        Input: nums = [3,0,1]
        Output: 2
        Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
        2 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]; // to be considered imagining array is sorted
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){ //since i starts with 0, we need to check if a[i]<array length
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for(int j=0 ; j<nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
