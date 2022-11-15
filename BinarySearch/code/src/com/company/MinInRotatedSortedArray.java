package com.company;
    /*
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        Date : 10-Sep-2022

        Input: nums = [4,5,6,7,0,1,2]
        Output: 0
        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     */
public class MinInRotatedSortedArray {
    public static void main(String[] args) {
       int[] arr ={3,4,5,1,2};
        System.out.println(findMin(arr));
    }
        public static int findMin(int[] nums) {
        int pivot = peakIndex(nums);
        int start =0 ;
        int end  = nums.length-1;
        System.out.println("Pivot : "+nums[pivot]);
        if(pivot<end){
            if(nums[pivot+1]<nums[start]){
                return nums[pivot+1];
            } else {
                return nums[start];
            }
        } else {
            return nums[start];
        }
    }
    public static int peakIndex(int[] arr){
        int start=0;
        int end= arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid<end && arr[mid] > arr[mid+1]){
                return mid;
            } else if (mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            } else if(end == mid){
                return mid;
            }
            else if(arr[mid] < arr[start]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
