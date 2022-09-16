class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        dp = new Integer[m][m];
        return maxScore(nums, multipliers, 0, 0, n, m);
    }
    
    int maxScore(int[] nums, int[] multipliers, int start,int idx, int n, int m){
        
        if(idx >= m) return 0;
        int end = n - 1 - (idx - start);
        int ans = 0;
        int startScore = 0;
        int endScore = 0;
        if(dp[start][idx] != null) return dp[start][idx];
        
        startScore = (nums[start] * multipliers[idx]) + maxScore(nums, multipliers, start + 1,idx + 1, n, m);
       
        endScore = (nums[end] * multipliers[idx] ) + maxScore(nums,multipliers, start, idx + 1, n, m);
                    
        return dp[start][idx] = Math.max(startScore, endScore);
    }
}
