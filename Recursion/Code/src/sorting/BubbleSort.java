package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,2};
        bubbleSort(arr, arr.length-1,0 );
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr, int r,  int c ){
       if(r==0){
           return;
       }
       if(c < r){
           if(arr[c] > arr[c+1]){
               swap(arr,c,c+1);
           }
           bubbleSort(arr,r,c+1);
       } else {
           bubbleSort(arr,r-1,0);
       }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
