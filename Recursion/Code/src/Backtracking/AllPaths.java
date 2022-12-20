package Backtracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true,true},
                {true,true,true},
                {true,true,true}
        };
//        allPath("",0,0,board);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("",0,0,board,path,1);
    }
    static void allPath(String p, int r, int c, boolean[][] maze){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;

        if(r < maze.length-1){
            allPath(p+'D',r+1,c,maze);
        }
        if(c < maze[0].length-1){
            allPath(p+'R',r,c+1,maze);
        }
        if(r > 0){
            allPath(p+'U',r-1,c,maze);
        }
        if(c > 0){
            allPath(p+'L',r,c-1,maze);
        }

        maze[r][c] = true;
    }

    static void allPathPrint(String p, int r, int c, boolean[][] maze,int[][] path, int step){
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
        if(r > 0){
            allPathPrint(p+'U',r-1,c,maze,path,step+1);
        }
        if(c > 0){
            allPathPrint(p+'L',r,c-1,maze,path,step+1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
