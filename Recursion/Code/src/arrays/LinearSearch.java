package arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,4,4,2,6,3,8};
//        System.out.println(isPresent(arr,4,0));
//        System.out.println(findIndex(arr,4,0));
//        ArrayList<Integer> list = findAllIndex(arr,4,0,new ArrayList<>());

        System.out.println(findAll(arr,4,0));

    }

    //passing array list within the body and not in parameter
    static ArrayList findAll(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
         ArrayList<Integer> addBelowListValues = findAll(arr,target,index + 1);
        list.addAll(addBelowListValues);
        return list;
    }


    //using array list to add all the duplicated elements
    static ArrayList findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr,target,index + 1,list);
    }

    static int findIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        } else {
            return findIndex(arr,target,index+1);
        }
    }

    static boolean isPresent(int[] arr, int target,int index){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || isPresent(arr,target, index+1);
    }
}
