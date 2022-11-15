package com.company;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[]  arr = {5,4,3,2,1};
//        int val = selectionSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void selectionSort(int[] arr){
        int count = 0;
        for(int i=0; i< arr.length;i++){
            /*if(count == 2)
                return arr[arr.length-2];
            count++;*/
            int last = arr.length-1 - i;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr,maxIndex,last);
        }
//        return 0;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for(int i=start ;i<=last; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}
