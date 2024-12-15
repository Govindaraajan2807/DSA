package com.company;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,3,5,2,4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        boolean swapped = false;
        for(int i=0; i< arr.length;i++){
            for(int j=1;j< arr.length-i;j++){ // j-i -> after n pass, the last n values will be sorted. So we can avoid j from checking the last n values
                if(arr[j]<arr[j-1]){
                    // swap the values
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
