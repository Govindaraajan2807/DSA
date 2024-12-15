import java.io.Console;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = minPathSum(grid);
        System.out.println(ans);
    }
    public static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i< grid.length;i++){
            for (int j =0;j<grid[i].length;j++){
                dp[i][j] += grid[i][j];
                if (i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i>0){
                    dp[i][j]+= dp[i-1][j];
                } else if (j>0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }

        for (int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}