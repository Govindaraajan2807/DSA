package com.company;

/*
        https://leetcode.com/problems/search-in-rotated-sorted-array/
        Date : 08-Sep-2022
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] arr = {1,2,4,5,6,3,2,0};
        int[] arr = {1,2,2};
//        int target = 15;
//        System.out.println(search(arr,target));
        System.out.println("Ans :"+ findPivotWithDuplicates(arr));

    }

    public static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
//        System.out.println("Position : "+pivot+" || Value : "+ arr[pivot]);
        if(pivot == -1){
            int ans = findIndex(arr,0,arr.length-1,target);
            return ans;
        }
        int firstSearch = findIndex(arr,0,pivot,target);
        int secondSearch = findIndex(arr,pivot+1,arr.length-1, target);
        if(firstSearch != -1){
            return firstSearch;
        } else if (secondSearch != -1){
            return secondSearch;
        }
        return -1;
    }

    public static int findIndex(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            } else if(target > arr[mid]){
                start = mid+1;
            } else
                return mid;
        }
        return -1;
    }

    public static int findPivot(int[] arr){
        int start=0;
        int end= arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid<end && arr[mid] > arr[mid+1]){
                return mid;
            } else if (mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            } if(arr[mid] <= arr[start]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && mid > start && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid-1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
