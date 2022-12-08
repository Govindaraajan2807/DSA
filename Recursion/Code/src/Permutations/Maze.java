package Permutations;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        printRoute("",3,3);
    }
    public static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int down = count(r-1,c);
        int right = count(r ,c-1);

        return down + right;
    }
    public static void printRoute(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            printRoute(p+'D',r-1,c);
        }
        if(c > 1){
            printRoute(p+'R',r,c-1);
        }
    }
}
