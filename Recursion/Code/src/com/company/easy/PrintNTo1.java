package com.company.easy;

public class PrintNTo1 {
    public static void main(String[] args) {
        printRev(5);
    }
    static void printBoth(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printBoth(n-1);
        System.out.println(n);
    }

    static void printRev(int n){
        if(n==0){
            return;
        }
        printRev(n-1);
        System.out.println(n);
    }
    static void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        print(n-1);
    }
}
