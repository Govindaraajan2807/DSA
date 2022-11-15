package com.company;

 /*
        https://leetcode.com/problems/peak-index-in-a-mountain-array/
        Date : 07 Sep 2022
  */

public class peakIndexInMountain {
    public static void main(String[] args) {
        int[] arr = {11,13,15,17};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] < arr[mid+1]){
                // ascending order
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start;
    }
}
