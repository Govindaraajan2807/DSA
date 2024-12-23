import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10; // Example value
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fib(n, dp));
    }
    public static int fib(int n, int[] dp){
       if(n <= 1){
           return n;
       }
       if (dp[n] != -1) return dp[n];
       dp[n] = fib(n-1,dp) + fib(n-2, dp);
//       System.out.println(dp[n]); // to print the series
       return dp[n];
    }
}
