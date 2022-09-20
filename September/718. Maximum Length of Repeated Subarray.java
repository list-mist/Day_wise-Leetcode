class Solution {
   
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        //findMaxLen(nums1,nums2,n1,n2);
        
        return max_length(nums1,nums2,n1,n2,dp);
    }
    int max_length(int[] nums1,int[] nums2,int n1,int n2,int[][] dp){
        int ans = 0;
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0  || j == 0){
                    continue;
                }
                else if(i > 0 && j > 0 && nums1[i-1] == nums2[j-1] ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
