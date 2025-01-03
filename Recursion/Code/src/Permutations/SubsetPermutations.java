package Permutations;

import java.util.ArrayList;

public class SubsetPermutations {
    public static void main(String[] args) {
//        permutation("","abc");
//        ArrayList<String> ans = permutationList("","abc");
//        System.out.println(ans);
        permutation("","abc");
    }

    public static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =  up.charAt(0);
        for(int i=0; i<=p.length();i++){ // <= because ch is being inserted and the length becomes n+1
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutation(first + ch + second, up.substring(1));
        }
    }

    public static ArrayList permutationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            ans.addAll(permutationList(first+ch+second,up.substring(1)));
        }
        return ans;
    }
}
