class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target+1];
        for(int i = 0; i <= target; i++) dp[i] = -1;
        //System.out.println(nums.length);
        return combination(nums, target);
    }
    int combination(int[] nums, int target){
        if(target == 0) {
            return 1 ;
        }
        if(dp[target] != -1) return dp[target];
        int res = 0;
        for(int t : nums){
            if(target - t >= 0)
            {
                res += combination(nums, target - t);
            }
        }
        dp[target] = res;
        
        return res;
    }
}
