package Backtracking;

public class SudokuSolver2 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        if(solveSudoku(board)){
            display(board);
        } else {
            System.out.println("Sudoku cannot be solved");
        }
    }

    static boolean solveSudoku(char[][] board){
        int row = -1;
        int col = -1;
        int n = board.length;

        boolean notEmpty = true;

        //start checking
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    notEmpty = false;
                    break;
                }
            }
            if(!notEmpty){
                break;
            }
        }
        if(notEmpty){
            return true;
        }

        //start placing the numbers
        for(int i=1;i<=9;i++){
            if(isSafe(board,row,col,(char)(i+'0'))){
                board[row][col] = (char)(i+'0');
                if(solveSudoku(board)){
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, char num){
        //to check the row
        for(int i=0;i< board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //to check the col
        for(int i=0;i< board.length;i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //to check the 3*3 matrix
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int i=rowStart; i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(char[][] board) {
        for(char[] row : board) {
            for(char num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
