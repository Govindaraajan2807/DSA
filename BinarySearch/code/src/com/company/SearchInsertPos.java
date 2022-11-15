package com.company;

//https://leetcode.com/problems/search-insert-position/

public class SearchInsertPos {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        int val = helper(nums, target);
        if(val != -1)
            return val;
        else
            return helper2(nums, target);
    }

    public static int helper(int[] nums, int target){
        int s = 0;
        int e = nums.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(target < nums[mid]){
                e = mid-1;
            }
            else if(target > nums[mid]){
                s = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int helper2(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(target > nums[nums.length-1]){
                return nums.length;
            } else if(target < nums[0]){
                return 0;
            }
            else if(target > nums[mid]){
                if(target < nums[mid+1])
                    return mid+1;
                else
                s = mid+1;
            }
            else if(target < nums[mid]){
                if(target > nums[mid-1])
                    return mid;
                else
                    e = mid-1;
            }
        }
        return nums.length;
    }
}
