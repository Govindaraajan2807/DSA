package Backtracking;

public class NKnights2 {
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knights(board,0,0,4);
    }
    static void knights(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length){
            return;
        }
        // condition to move to next row
        if(col == board.length){
            knights(board, row+1, 0, knights);
            return;
        }

        //condition to check if it is safe to place the knights
        if(isSafe(board,row,col)){
            board[row][col] = true;
            knights(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        knights(board, row, col+1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // 4 conditions to check for safe position

        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }


    private static void display(boolean[][] board) {
        System.out.println(count++);
        for (boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("K ");
                }else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}
