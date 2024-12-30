//https://leetcode.com/problems/house-robber/

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,25,3,1,3,5,8,1,9};
        int ans = rob(nums);
        System.out.println(ans);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solveTabulation(dp,nums);
    }

    static int solve(int index, int[] dp, int[] nums){
        if(index==0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + solve(index-2,dp,nums);
        int notPick = solve(index-1,dp,nums);

        return dp[index] = Math.max(pick,notPick);
    }

    static int solveTabulation(int[] dp, int[] nums){
        dp[0] = nums[0];//1

//      1,25,3,1,3,5,8,1,9

        for(int i=1;i<nums.length;i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];

            dp[i] = Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }

    static int solveSpaceOptimization(int[] nums){
        int prev = nums[0];
        int prev2 = 0;

        for(int i=1;i< nums.length;i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev2;
            }
            int nonPick = prev;

            int curr = Math.max(pick,nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
