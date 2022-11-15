package Permutations;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        pad("","12");
    }

    // void method that prints all the permutations
    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for (int i=(digit-1)*3; i < digit*3; i++){
            char ch = (char) ('a' + i);
            pad(p+ch,up.substring(1));
        }
    }

    // returns as a list by passing the array list in the body
    static ArrayList<String> padList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
        }

        int digit = up.charAt(0) - '0';

        ArrayList<String> list = new ArrayList<>();

        for (int i=(digit-1)*3; i < digit*3; i++){
            char ch = (char) ('a' + i);
            list.addAll(padList(p+ch,up.substring(1)));
        }
        return list;
    }

    // returns the count of total permutations
    static int padCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int digit = up.charAt(0) - '0';
        int count = 0;

        for (int i=(digit-1)*3; i < digit*3; i++){
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
