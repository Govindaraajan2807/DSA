package com.company;

public class PositionInInfiniteArray {
    public static void main(String[] args) {
        int[] nums = {3,5,7,9,10,90,100,130,140,160,170};
        int target = 10;
        int position = positionInfiniteArray(nums, target);
        System.out.println(position);
    }
    static int positionInfiniteArray(int[] nums, int target){
        int start = 0;
        int end = 2;
        int mid = Integer.MIN_VALUE;
        while(start <= end){
            if(target > nums[end]){
                try{
                    int temp = end + 1; //temporary new start
                    // new end size = previous end + 2 * size of the box
                    end = end + (end - start+1)*2;
                    start = temp;
                    continue;
                } catch (ArrayIndexOutOfBoundsException ex){
                    // do nothing
                }
            }
            mid = start + (end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            } else if(target > nums[mid]){
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
