class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return path(m - 1,n - 1, dp);
    }
    
    int path(int m, int n, int[][] dp){
        
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        if(dp[m][n] != 0) return dp[m][n];
        
        int a = path(m - 1, n, dp);
        
        int b = path(m, n - 1, dp);
        
        return dp[m][n] = a + b;
    }
}
