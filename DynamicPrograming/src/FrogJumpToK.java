//https://www.geeksforgeeks.org/minimum-cost-for-hopping-frog-to-reach-stair-n/

public class FrogJumpToK {
    public static void main(String[] args) {

    }

    static int frogJumpToKMemoization(int index, int[] height, int[] dp, int k){
       if(index == 0){
           return 0;
       }
       if(dp[index] != -1)
           return dp[index];
       int maxSteps = Integer.MAX_VALUE;
       for(int i=1;i<=k;i++){
           if(index - i >= 0){
               int jump = frogJumpToKMemoization(index-i, height,dp,k) - Math.abs(height[index] - height[index-i]);
               maxSteps = Math.min(jump,maxSteps);
           }
       }
       return dp[index] = maxSteps;
    }

    static int frogJumpToKTabulation(int index, int[] height, int[] dp, int k){
        if(index == 0){
            return 0;
        }
        if(dp[index] != -1)
            return dp[index];
        int maxSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(index - i >= 0){
                int jump = frogJumpToKTabulation(index-i, height,dp,k) - Math.abs(height[index] - height[index-i]);
                maxSteps = Math.min(jump,maxSteps);
            }
        }
        return dp[index] = maxSteps;
    }
}
