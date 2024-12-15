package com.company;

import java.util.Arrays;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] arr ={
                {1,3,5,7},
                {29,25,35,45},
                {28,15,37,49},
                {33,34,38,50}
//                {1,3}
        };
        System.out.println(Arrays.toString(search(arr,3)));
    }
    public static int[] search(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length-1;
        int temp = 1;

        while(r< matrix.length-1 && c >=0){
            if(target == matrix[r][c]){
                return new int[]{r,c};
            } else if(matrix[r][c] > target){
                c--;
            } else {
                r++;
            }
        }
        int counter = 0;
        for(int i=0; i<=temp;i++){
            if(matrix[i][counter++] == target){
                return new int[]{i,counter};
            }
        }
        return new int[]{-1,-1};
    }
}
