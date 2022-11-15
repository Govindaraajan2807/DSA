package com.company;
/*
    https://leetcode.com/problems/reverse-words-in-a-string-iii/
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Palindrome {

    public static void main(String[] args) {
        String string = "Let's take LeetCode contest";
        System.out.println(reverseWords(string));
    }
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start =0;
        for(int end=0; end  <= chars.length;end++){
            if(end == chars.length || chars[end]==' ' ){
                swap(chars, start, end-1);
                start = end+1;
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int start, int i) {
        while(start < i) {
            char temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
            start++;
            i--;
        }
    }

}
