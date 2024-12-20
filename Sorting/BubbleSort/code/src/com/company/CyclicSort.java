package com.company;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr ={3,4,2,1,5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){ //
            int index = arr[i]-1; //2
            if(arr[i] != arr[index]){ // 3 != 1
                swap(arr,i,index);
            } else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
