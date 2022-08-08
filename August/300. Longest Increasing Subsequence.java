class Solution {
    int maxVal = 0;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        dp = new int[n][10000];
        
        int ans = LIS(nums, n - 1, n );   
        
        return ans;
        
    }
    
    int LIS(int[] nums, int n, int prev){
        if(n == 0){
            if(prev != nums.length && nums[prev] > nums[0]) return 1;
            return 0;
        }
        if(dp[n][prev] != 0) {
            return dp[n][prev];
        }
        int take = 0;
        if(prev == nums.length  || (nums[prev] > nums[n])){
            take = 1 + LIS(nums, n - 1, n);
        }
        int notTake = LIS(nums, n - 1, prev);
       // System.out.println(take + " " + notTake + " " + prev);
       // maxVal = Math.max(take,notTake);
        return dp[n][prev] = Math.max(take,notTake);
    }
}
