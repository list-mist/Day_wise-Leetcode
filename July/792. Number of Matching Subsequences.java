class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(isSubsequence(e.getKey(),s)) {
                cnt += e.getValue();
            }
        }
        
        return cnt;
    }
    
    boolean isSubsequence(String s, String t) {
        int cnt = 0;
        
        int i = 0, j = 0;
        
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                cnt++;
            }
            else{
                j++;
            }
        }
        
        return cnt == s.length();
    }
}
