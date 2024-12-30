//https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/
//https://leetcode.com/problems/house-robber-ii/

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int ans = rob(nums);
        System.out.println(ans);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int[] arr1 = Arrays.copyOfRange(nums,0,n-1);
        int[] arr2 = Arrays.copyOfRange(nums,1,n);

        int first = solveUtil(arr1);
        int second = solveUtil(arr2);
        return Math.max(first,second);
    }

    static int solveUtil(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(arr.length -1,dp,arr);
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

    static int solveTabulation(int index, int[] dp, int[] nums){

        dp[0] = nums[0];

        for(int i=0;i<nums.length;i++){
            int pick = nums[index];
            if(i>1){
                pick += dp[index-2];
            }
            int notPick = dp[index-1];
            dp[index] = Math.max(pick,notPick);
        }

        return dp[nums.length-1] ;
    }
}
