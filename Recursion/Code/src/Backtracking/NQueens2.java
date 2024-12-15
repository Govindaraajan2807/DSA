package Backtracking;

public class NQueens2 {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        queens(board,0);
    }
    static void queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return;
        }

        int count = 0;
        for(int col =0;col<board.length;col++){
            board[row][col] = true;
            if(isSafe(board,row,col)){
                queens(board,row+1);
            }
            board[row][col]= false;
        }
        return;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //to check the vertical
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        //to check the left diagonal
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //to check the right diagonal
        int maxRight = Math.min(row, board.length-col-1);
        for(int i=1;i<=maxRight;i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print('Q');
                } else {
                    System.out.print('X');
                }
            }
            System.out.println();
        }
    }
}
