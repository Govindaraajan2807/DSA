package com.company.easy;

public class SumOfDigits {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        System.out.println(arr.length);
//        System.out.println(sum(1234));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return (n%10) + sum(n/10);
    }
}
