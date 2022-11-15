package Strings;

public class SkipWord {
    public static void main(String[] args) {
        String string = "bdapplefg";
        System.out.println(skipWord(string));
    }
    static String skipWord(String string){
        if(string.isEmpty()){
            return "";
        }
        if(string.startsWith("apple")){
            return skipWord(string.substring(5));
        } else {
            return string.charAt(0) + skipWord(string.substring(1));
        }
    }
}
