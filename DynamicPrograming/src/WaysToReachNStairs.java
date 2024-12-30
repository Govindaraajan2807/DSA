// https://leetcode.com/problems/climbing-stairs/description/

public class WaysToReachNStairs {
    public static void main(String[] args) {

    }

    // basic recursion (Time limit will exceed)
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int one = climbStairs(n-1);
        int two = climbStairs(n-2);
        return one + two;
    }

    // Using Dynamic Programming
    public int climbStairsDP(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Space Optimization
    public int climbStairsSpaceOptimized(int n) {
        if(n<=1){
            return 1;
        }
        int prev2 = 1;
        int prev1 = 1;
        for(int i=2;i<=n;i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}


