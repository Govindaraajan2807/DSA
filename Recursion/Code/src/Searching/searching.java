package Searching;

import java.util.ArrayList;

public class searching {

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,5,3,6};
        System.out.println(findAllIndex(arr,0,4,new ArrayList<>()));
    }

    static boolean find(int[] arr, int index, int target){
        if(index == arr.length)
            return false;

        return arr[index] == target || find(arr,++index,target);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int index, int target, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr,++index,target,list);
    }
}
