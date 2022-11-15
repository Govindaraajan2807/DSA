package com.company;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int ans = findMin(arr);
        System.out.println(ans);
    }
    public static int findMin(int[] nums) {
        if(nums.length == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        } else if(nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid>start && nums[mid] > nums[mid-1]){
                return nums[mid-1];
            }
            if(mid<end && nums[mid] < nums[mid+1]){
                return nums[mid];
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                if(start < end && nums[start]>nums[start+1]) {
                    return nums[start + 1];
                }
                    start++;
                if(end>start && nums[end]>nums[end-1]){
                    return nums[end-1];
                }
                    end--;
                } else if(nums[start]<nums[mid] || (nums[start] == nums[mid] && nums[mid]>nums[end])){
                    start = mid + 1;
                } else {
                  end = mid - 1;
                }
            }
        return -1;
    }
}
