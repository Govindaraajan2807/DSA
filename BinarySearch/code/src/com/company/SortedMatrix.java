package com.company;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3,4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(search(arr, 16)));
    }
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd-cStart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            } else if(matrix[row][mid] < target){
                cStart = mid+1;
            } else{
                cEnd = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int[][] matrix, int target){
        int row = matrix.length;
        int cols = matrix[0].length;
        // cols may be empty
        if(cols == 0){
            return new int[]{-1,-1};
        }
        if(row == 1){
            return binarySearch(matrix,0,0,cols-1,target);
        }

        int rStart = 0;
        int rEnd = row-1;
        int cMid = cols/2;

        while(rStart < (rEnd-1)) { // this will always check that there is at least 2 rows present
            int mid = rStart + (rEnd - rStart)/2;
            if(matrix[mid][cMid] == target){
                return new int[]{mid, cMid};
            } else if(matrix[mid][cMid] < target){
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }
        // now we will have only two rows left
        // check in the column of 2 rows that is present
        if(matrix[rStart][cMid] == target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid] == target){
            return new int[]{rStart+1, cMid};
        }
        // checking in the first half
        if(target >= matrix[rStart][cMid] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid,cols-1,target);
        }
        // checking in the second half
        if(target <= matrix[rStart][cMid]){
            return binarySearch(matrix,rStart,0,cMid,target);
        }
        // checking in the third half
        if(target >= matrix[rStart+1][cMid]){
            return binarySearch(matrix,rStart+1,cMid,cols-1,target);
        }
        // checking in the fourth half
        else{
            return binarySearch(matrix,rStart+1,0,cMid,target);
        }
    }
}














