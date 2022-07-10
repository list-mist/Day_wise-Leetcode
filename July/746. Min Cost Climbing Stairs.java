class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length+1];
        return Math.min(minCost(cost, 0, dp), minCost(cost, 1, dp));
    }
    
    
    int minCost(int[] cost, int i, int[] dp){
        if(i == cost.length - 1) return cost[i];
        if(i > cost.length - 1) return 0;
        if(dp[i] != 0) return dp[i];
        int a = cost[i] + minCost(cost, i + 1, dp);
        int b = cost[i] + minCost(cost, i + 2, dp);
        
        return dp[i] = Math.min(a, b);
    }
}
