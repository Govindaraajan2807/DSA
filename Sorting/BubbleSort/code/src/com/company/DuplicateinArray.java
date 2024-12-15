package com.company;
/*
        Qn : https://leetcode.com/problems/find-the-duplicate-number/
 */
public class DuplicateinArray {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }
    public static int findDuplicate(int[] nums) {



        return -1;
    }


    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


/*
int i = 0;
        int end = nums.length-1;
        while(i <= end){
            if(nums[i] != i +1){
                int correct = nums[i]-1;
                if(nums[correct] != nums[i]) {
                    swap(nums, i, correct);
                } else {
                    return nums[i];
                }
            }
            else
                i++;
            }
 */