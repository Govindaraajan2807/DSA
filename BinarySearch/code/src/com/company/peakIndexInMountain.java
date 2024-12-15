package com.company;

 /*
        https://leetcode.com/problems/peak-index-in-a-mountain-array/
        Date : 07 Sep 2022
  */

public class peakIndexInMountain {
    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test(){
        int[] arr = {1,2,3,4,5,3,1};
        int peak = peakIndexInMountainArray(arr);
        int start = 0;
        int target = 15;
        System.out.println(peak);
        int firstOccurence = binarySearch(arr, start, peak, target);
        if(firstOccurence != -1){
            return firstOccurence;
        }
        return binarySearch(arr, peak+1, arr.length-1, target);
    }

    static int binarySearch(int[] arr, int start, int end, int target ){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            } else if (target >  arr[mid]){
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            System.out.println("Mid element --> " + arr[mid]);
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }


}
