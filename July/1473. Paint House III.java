class Solution {
    int[][][] dp;
    int MAX = (int) Math.pow(10,9) + 7;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        dp = new int[houses.length+1][target+1][m+1];
        int res = minCostVal(houses, cost, n, target, 0, 0);
        return res == MAX ? -1 : res;
    }
    
    int minCostVal(int[] h, int[][] cost,  int n, int target, int prev, int i){
       
        if(target < 0) return MAX;
        
        if(i >= h.length) return target == 0 ? target : MAX;
        
        if(dp[i][target][prev] >  0) return dp[i][target][prev];
    
        if(h[i] != 0){
            if(prev != h[i]){
                target = target - 1;
            }
            return minCostVal(h, cost, n, target, h[i], i + 1);
        }
        int res = MAX;
        
        for(int j = 1; j <= n; j++){
            res = Math.min(cost[i][j-1] + minCostVal(h,cost,n,target - (prev != j ? 1 : 0), j, i + 1), res);
        }
        dp[i][target][prev] = res;
        return res;
    }

}
