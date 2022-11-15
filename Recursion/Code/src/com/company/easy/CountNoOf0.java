package com.company.easy;

public class CountNoOf0 {
    public static void main(String[] args) {
        int n = 10204;
        System.out.println(count0(n));
    }
    static int count0(int n){
        return helper(n,0);
    }

    // special pattern : how to pass a number to above calls
    private static int helper(int n, int c) {
        if(n==0){
            return c;
        }
        int rem = n%10;
        if(rem == 0) c = c+1;
        return helper(n/10,c);
    }
}

/*
if(n==0){
            return c;
        }
        int rem = n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }
 */