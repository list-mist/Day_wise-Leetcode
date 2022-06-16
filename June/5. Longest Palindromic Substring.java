class Solution {
    public String longestPalindrome(String s) {
        return longestPalindSub(s,s);
    }
    String longestPalindSub(String s1,String s2){
        int n = s1.length();
        
        int[][] dp = new int[n][n];
        String ans = "";
        int max = Integer.MIN_VALUE, idx = 0;
        int start = 0;
        for(int gap = 0; gap < n; gap++)
        {
            for(int i  = 0, j = gap; j < n && i < n; i++, j++){
                if(i == j) dp[i][j] = 1;
                else if(j - i == 1){
                     if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = 2 ;
                    }
                }
                else if(j - i >= 2){
                  
                    if(s1.charAt(i) == s2.charAt(j)){
                        if(dp[i+1][j-1] != 0)
                        {
                            dp[i][j] = 2 + dp[i+1][j-1]; 
                        }
                    }
                }
                if(max < dp[i][j]) {
                    max = dp[i][j];
                    idx = j;
                    start = i;
                   
                }
            }
        }
       
        ans = s1.substring(start, idx+1);
   
        return ans;
    }
}
