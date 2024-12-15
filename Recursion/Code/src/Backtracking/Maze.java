package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
/*        System.out.println(count(3,3));
        printRoute("",3,3);
        System.out.println(printRouteList("",3,3));*/

        boolean[][] board = {
                {true, true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][]path = new int[board.length][board[0].length];
        allPathPrint("",0,0,board,path,1);
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

    public static void printPathRoute(String p, int r, int c){
        if(r==1 || c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            printPathRoute(p+'D',r-1,c);
        }
        if(c >1){
            printPathRoute(p+'R',r,c-1);
        }
    }

    public static int route(int r, int c){
        if (r == 1 || c == 1){
            return 1;
        }

        int down = route(r-1,c);
        int right = route(r,c-1);
        return down+right;
    }

    static void mazeAllPath(String p, int r, int c, boolean[][] maze){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;

        if(r< maze.length-1){
            mazeAllPath(p+'D',r+1,c,maze);
        }
        if(c < maze[0].length-1){
            mazeAllPath(p+'R',r,c+1,maze);
        }
        if(r>0){
            mazeAllPath(p+'U',r-1,c,maze);
        }
        if(c >0){
            mazeAllPath(p+'L',r,c-1,maze);
        }

        maze[r][c] = true;
    }

    public static void allPathPrint(String p, int r, int c, boolean[][] maze, int[][]path, int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length-1){
            allPathPrint(p+'D',r+1,c,maze,path,step+1);
        }
        if(c < maze[0].length-1){
            allPathPrint(p+'R',r,c+1,maze,path,step+1);
        }
        if(r>0){
            allPathPrint(p+'U',r-1,c,maze,path,step+1);
        }
        if(c>0){
            allPathPrint(p+'L',r,c-1,maze,path,step+1);
        }
        maze[r][c] = true;
        path[r][c] = 0;

    }
}
