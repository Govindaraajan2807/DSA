package Leetcode;

public class FindInMountain {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int ans = findInArray(target,arr);
        System.out.println(ans);
    }
    public static int findInArray(int target, int[] arr) {
        int len = arr.length;
        int start = 0;
        int end = len-1;
        int peak =  peakIndex(arr);
        int firstOccurence = orderAgnosticBS(arr, start, peak, target);
        if(firstOccurence != -1){
            return firstOccurence;
        }
        int secondOccurence = orderAgnosticBS(arr, peak+1, end, target);
        return secondOccurence;
    }

    static int orderAgnosticBS(int[] arr, int start, int end, int target ){

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > arr[mid]){
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }


    public static int peakIndex(int[] arr) {
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
