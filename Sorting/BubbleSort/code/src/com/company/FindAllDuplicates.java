package com.company;
/*
        https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> duplicate = findDuplicates(arr);
        System.out.println(duplicate);
    }
    public static List<Integer> findDuplicates(int[] arr) {
        int index = 0;
        int end = arr.length-1;
        List<Integer> duplicate = new ArrayList<>();
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
                duplicate.add(arr[j]);
            }
        }
        return duplicate;
    }
    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
