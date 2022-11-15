package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        https://leetcode.com/problems/set-mismatch/
 */
public class MissingSet {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }
    public static int[] findErrorNums(int[] arr) {
        int index = 0;
        int end = arr.length-1;
//        List<Integer> duplicate = new ArrayList<>();
        while(index <= end) {
            int correct = arr[index]-1;
            if(arr[correct] != arr[index]){
                swap(arr,index,correct);
            } else{
                index++;
            }
        }
        for(int j=0 ;j< arr.length;j++){
            if(arr[j] != j+1){
                return new int[]{arr[j],j+1};
            }
        }
//        return duplicate;
        return new int[]{-1,-1};
    }
    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
