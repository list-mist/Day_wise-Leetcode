class Solution {
    public int minDistance(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int res = lcs(s1,s2);
        int n1 = s1.length();
        int n2 = s2.length();
        
        int ans = n1 - res + n2 - res;
     
        return ans;
        
    }
  
    int lcs(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for(int i = 1; i < n1; i++){
            if(s1.charAt(i) == s2.charAt(0)) dp[i][0] = 1;   
            else{
                dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
            }
        }
        for(int i = 1; i < n2; i++){
            if(s1.charAt(0) == s2.charAt(i)) dp[0][i] = 1;    
             else{
                dp[0][i] = Math.max(dp[0][i-1], dp[0][i]);
            }
        }
        
        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1-1][n2-1];
    }
}
