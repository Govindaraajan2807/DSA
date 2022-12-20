package Backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        printRoute("",3,3);
        System.out.println(printRouteList("",3,3));

        boolean[][] board = {
                {true, true,true},
                {true,false,true},
                {true,true,true}
        };
        printRouteRestrictions("",0,0,board);
    }

    public static void printRouteRestrictions(String p, int r, int c, boolean[][] maze){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length-1){
            printRouteRestrictions(p+'D',r+1,c,maze);
        }
        if(c < maze[0].length-1){
            printRouteRestrictions(p+'R',r,c+1,maze);
        }
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
    public static ArrayList printRouteList(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(printRouteList(p+'D',r-1,c));
        }
        if(c > 1){
            list.addAll(printRouteList(p+'R',r,c-1));
        }
        return list;
    }
}
