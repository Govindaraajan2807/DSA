package com.company;

/*
        https://leetcode.com/problems/find-in-mountain-array/
        Date : 08-Sep-2022

        Input: array = [1,2,3,4,5,3,1], target = 3
        Output: 2
        Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 */

public class FindInMountain {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println("Pivot position : "+peakElementInMountain(arr) +" value : "+ arr[peakElementInMountain(arr)]);
        int target = 3;
        int ans = search(arr,target);
        System.out.println(ans);
    }

    public static int orderAgnosticSearch(int[] arr, int start, int end, int target){
//        int start = 0;
//        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid -1;
                } else
                    start = mid + 1;
            } else {
                if(target > arr[mid]){
                   end = mid-1;
                } else
                    start = mid +1;
            }
        }
        return -1;
    }

    static int search(int[] arr, int target){
        int peak = peakElementInMountain(arr);
        int firstTry = orderAgnosticSearch(arr,0,peak,target);
        if(firstTry != -1){
            return firstTry;
        }
        // search in the second half
        int secondTry = orderAgnosticSearch(arr,peak+1,arr.length-1,target);
        if(secondTry!=-1){
            return secondTry;
        }
        return -1;
    }

    public static int peakElementInMountain(int[] arr){
        int start = 0;
        int end = arr.length;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                // descending order
                end = mid;
            } else if(arr[mid] < arr[mid+1]){
                // ascending order
                start = mid+1;
            }
        }
        return start;
    }
}
