package com.company;

import java.util.ArrayList;
import java.util.List;

/*
        https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
        Input: nums = [4,3,2,7,8,2,3,1]
        Output: [5,6]
 */
public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while( i<arr.length){
            int correct = arr[i]-1;
            if( arr[i]!=arr[correct]){ //since it is 1 - N no need to check a[i] < array length
                swap(arr, i, correct);
            } else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int j=0;j<arr.length;j++){
            if(arr[j] != j+1 ){
                ans.add(j+1);
            }
        }
        return ans;
    }

    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
