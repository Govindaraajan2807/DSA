//https://www.geeksforgeeks.org/minimum-cost-for-hopping-frog-to-reach-stair-n/

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {

        int[] heights = new int[]{20, 30, 40, 20};
        int[] dp = new int[heights.length];
        Arrays.fill(dp,-1);
        System.out.println(calculateJumpMemoization(heights, heights.length-1, dp));
    }

    // Memoization method
    static int calculateJumpMemoization(int[] heights, int n, int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n] != -1) return dp[n];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = calculateJumpMemoization(heights, n-1, dp) + Math.abs(heights[n] - heights[n-1]);
        if(n>1){
            jumpTwo = calculateJumpMemoization(heights, n-2, dp) + Math.abs(heights[n] - heights[n-2]);
        }

        dp[n] = Math.min(jumpOne,jumpTwo);
        return dp[n];
    }

    // tabulation method
    static int calculateJumpTabulation(int[] height, int[]dp){
        dp[0]=0;
        for(int i=1;i<= dp.length-1;i++){
            int twoJump = Integer.MAX_VALUE;
            int oneJump = dp[i-1] + Math.abs(height[i] - height[i-1]);
            if(i > 1){
                twoJump = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(oneJump,twoJump);
        }
    return dp[dp.length-1];
    }

    // space optimization approach
    static int calculateJumpSpaceOptimization(int[] height, int n){

        int prev = 0;
        int prev2 = 0;

        for(int i=1;i< height.length;i++){
            int twoJump = Integer.MAX_VALUE;
            int oneJump = prev2 + Math.abs(height[i] - height[i-1]);
            if(i > 1){
                twoJump = prev2 + Math.abs(height[i] - height[i-2]);
            }
            int current_i = Math.min(oneJump,twoJump);
            prev2 = prev;
            prev = current_i;
        }
        return prev;
    }

}
