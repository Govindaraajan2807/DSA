package Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

    }

    static boolean solve(int[][] board){
        int row  = -1;
        int col = -1;
        int n = board.length;

        boolean noEmptyLeft = true;

        // replacing the row, col in the arguments
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    noEmptyLeft = false;
                    break;
                }
            }
            if(!noEmptyLeft){
                break;
            }
        }
        if(noEmptyLeft){
            //sudoku is solved
            return true;
        }

        // backtracking the visited elements if required
        for(int num=1; num<=9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num){
        //to check the row
        for(int i=0; i< board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //to check the col
        for(int i=0; i< board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //to check the matrix
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return  false;
                }
            }
        }
        return true;
    }
    private static void display(int[][] board) {
        for(int[] row : board) {
            for(int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
