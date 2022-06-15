class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new custom());
        return longestChain(words);   
    }
    class custom implements Comparator<String>{
        public int compare(String a, String b){
            return a.length() - b.length();
        }
    }
    int longestChain(String[] words){
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                 boolean res = valid(words[i],words[j]);
                if(res){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    boolean valid(String s1, String s2){
        if(s2.length() - s1.length() != 1) return false;
        int cnt =  0;
        int i = 0, j = 0;
        
        while(i < s1.length() && j < s2.length()){
             if(s1.charAt(i) != s2.charAt(j)){
                cnt++;
                j++;
            }else{
                 i++;
                 j++;
             }
        }
        
        return cnt <= 1;
    }
    
}
