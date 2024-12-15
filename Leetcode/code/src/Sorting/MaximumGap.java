package Sorting;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        int[] nums = {1,4,2};

        // Ensure the array has at least 2 elements
        if (nums.length < 2) {
            System.out.println(0);
            return;
        }

        // Sort the array in ascending order
        Arrays.sort(nums);

        int max = 0;

        // Loop through the array and calculate the maximum gap
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int gap = nums[j] - nums[i];
            if (gap > max) {
                max = gap;
            }
        }

        // Return the maximum gap
        System.out.println(max);
    }



}
