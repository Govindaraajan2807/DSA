package com.company.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,67,89};
        int target = 89;
        System.out.println(binarySearch(arr,target,0,arr.length-1));

    }
    static int binarySearch(int[] arr, int target, int s, int e){
        if( s > e){
            return -1;
        }
        int mid = s + (e-s)/2;
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid] < target){
            return binarySearch(arr,target,mid+1,e);
        }
        return binarySearch(arr,target,s,mid-1);
    }
}
