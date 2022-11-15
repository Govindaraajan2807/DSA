package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,2};
//        selectionSort(arr,arr.length-1);
        selectionSortRec(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSortRec(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }

        if(c < r){
            if(arr[c] > arr[max]){
                selectionSortRec(arr, r, c+1, c);
            } else {
                selectionSortRec(arr, r, c+1, max);
            }
        } else{
            swap(arr,max,r-1);
            selectionSortRec(arr, r-1, 0, 0);
        }
    }

    static void selectionSort(int[] arr, int last){
        if(last < 0){
            return;
        }
        int max = getMaxIndex(arr,0,last);
        swap(arr, max, last);
        selectionSort(arr,last-1);
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
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
