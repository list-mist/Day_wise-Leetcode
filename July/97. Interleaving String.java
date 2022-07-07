class Solution {
    boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 + n2 != s3.length()) return false;
        dp = new boolean[n1+1][n2+1];
      //  return fun(s1,s2,s3,0,0,0);
        return table(s1,s2,s3,n1,n2,s3.length());
    }
    
//    boolean fun(String s1, String s2, String s3, int i1, int i2, int i3 ){
//         //System.out.println(i1+" "+i3+" "+i2);
//         if(i1 + i2 != i3) return false;
//         if(i1 == s1.length()){
//             return s2.substring(i2).equals(s3.substring(i3));
//         }
//         if(i2 == s1.length()){
//             return s1.substring(i1).equals(s3.substring(i3));
//         }
//         if(dp[i1][i2] != 0) return true;
//         boolean left = false;
       
//         if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
//              left = fun(s1,s2,s3,i1+1,i2,i3+1);
//         }
//         if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)){
//              left = left || fun(s1,s2,s3,i1,i2+1,i3+1);
//         }
//         if(left ){
//             dp[i1][i2] = 1;
//         }
//         return left ;
//     }
    boolean table(String s1, String s2, String s3, int n1, int n2, int n3){
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j+i-1);
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }else{
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) )|| ( dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[n1][n2];
    }
}
