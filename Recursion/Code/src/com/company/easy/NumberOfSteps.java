package com.company.easy;
/*
    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class NumberOfSteps {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(numberOfSteps(14));
    }
    static int numberOfSteps(int num){
        return helper(num,0);
    }

    private static int helper(int n, int c) {
        if(n==0){
            return c;
        }
        if(n%2==0){
            return helper(n/2,c+1);
        }
        return helper(n-1,c+1);
    }
}
