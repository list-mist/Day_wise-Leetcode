class Solution {
    public int minDeletions(String s) {
        
        int[] lis = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            lis[ch - 'a'] += 1;
           
        }
        Arrays.sort(lis);
        int maxVal = lis[lis.length - 1];
        int minDeletions = 0;
        
        for(int i = lis.length - 1; i >= 0; i--){
            if(lis[i] == 0) break;
            if(maxVal < lis[i]){
                if(maxVal < 0){
                    minDeletions += lis[i];
                }
                else{
                    minDeletions += lis[i] - maxVal;
                }
            }
           maxVal = Math.min(lis[i] - 1, maxVal - 1);
        }
        
        return minDeletions;
    }
}
