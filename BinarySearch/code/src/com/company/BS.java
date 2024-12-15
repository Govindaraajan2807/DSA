package com.company;

public class BS {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,3,1};
        int target = 8;
        System.out.println(search(nums,target));

    }
    static int search(int[] arr, int target){
        int peakIndex = peakElementInArray(arr);
        int firstSearch = binarySearch(arr, 0, peakIndex,target);
        if(firstSearch != -1){
            return firstSearch;
        }
        int secondSearch = binarySearch(arr,peakIndex+1,arr.length-1,target);
        return secondSearch != -1 ? secondSearch : -1;
    }

    static int peakElementInArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            } else if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }
        }
        return start;
    }

    static int binarySearch(int[] nums, int start, int end, int target){

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if(target < nums[mid]){
                end = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
