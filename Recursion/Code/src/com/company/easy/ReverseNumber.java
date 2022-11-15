package com.company.easy;

public class ReverseNumber {
    static int sum = 0;
    static void rev1(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        sum = sum * 10 + rem;
        rev1(n/10);
    }

    static int rev2(int n){
        int digits = (int)(Math.log10(n)) +1;
        int value  = helper(n, digits);
        System.out.println(value);
        return value;
//        return helper(n, digits);

    }

    private static int helper(int n, int digits) {
        if(n%10 == 0){
            return n;
        }
        int rem = n%10;
        return rem * (int)(Math.pow(10,digits-1)) + helper(n/10, digits-1);
    }

    static boolean palin(int n){
        int value = rev2(n);
//        System.out.println(value);
        return n == value;
    }

    public static void main(String[] args) {
//        rev1(1234);
//        System.out.println(sum);
        System.out.println(rev2(1234));
//        System.out.println(palin(1234));
    }
}
