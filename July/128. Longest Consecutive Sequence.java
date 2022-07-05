class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] == 1){
                dp[i] = 1 + dp[i-1];
            }else if(nums[i] == nums[i-1]){
                dp[i] = Math.max(dp[i],dp[i-1]);
            }
        }
        int max = 0;
        
        for(int i : dp) max = Math.max(max, i);
        return max;
    }
}
