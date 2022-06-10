class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] idx = new int[128];
        Arrays.fill(idx, -1);
        int i = 0, j = 0, n = s.length();
        if(n == 1) return 1;
        int max = 0;
        while(j < n){
            if(idx[s.charAt(j)] == -1){
                idx[s.charAt(j)] = j;
                j++;
            }else{
                i = Math.max(i,idx[s.charAt(j)] + 1);
                idx[s.charAt(j)] = -1;
            }
      
            max = Math.max(max,j - i);
        }
        return max;
    }
}
