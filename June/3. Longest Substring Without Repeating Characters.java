class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<String> q = new LinkedList<>();
        
        int i = 0, j = 0, n = s.length();
        if(n == 1) return 1;
        int max = 0;
        
        while(j < n){
            if(!q.contains(s.substring(j,j+1))) {
                q.add(s.substring(j,j+1));
                j++;
            }
            else{
                q.poll();
                i++;
            }
            max = Math.max(max,q.size());
          
        }
        return max;
    }
}
