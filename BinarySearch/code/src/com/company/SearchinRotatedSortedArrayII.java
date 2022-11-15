package com.company;
/*
        https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
        Date : 11 Sep 2022
*/
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
//        int pivotPos = findPivotWithDuplicates(nums);
//        System.out.println("Pivot position : "+pivotPos +" value : "+ nums[pivotPos]);
        int target = 3;
        System.out.println(search(nums,target));

    }
    public static boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);
        if (pivot == -1){
            return binarySearch(nums, 0, nums.length-1, target);
        }
        if(target == nums[pivot]){
            return true;
        }
        if(nums[0] <= target){
            return binarySearch(nums,0,pivot-1,target);
        } else {
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                return true;
            }
            else if(target<arr[mid]){
                end = mid-1;
            } else if(target>arr[mid]){
                start = mid+1;
            } else{
                return true;
            }
        }
        return false;
    }

    public static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            // 4 cases over here
            if ( mid < end && arr[mid] > arr[mid + 1] ) {
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                //check if start and end are not the pivots. If so, then return the values
                if(start<end && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>start && arr[end-1]>arr[end]){
                    return end-1;
                }
                end--;
            }
            // left array is sorted. Check for the pivot in right array
            else if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end])){
                start = mid +1;
            } else {
                end = mid-1;
            }
        }
        return -1;

    }
}
