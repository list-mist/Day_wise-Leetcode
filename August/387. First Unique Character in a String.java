class Solution {
    public int firstUniqChar(String s) {
        
        for(int i = 0; i < s.length(); i++){
            String a = s.substring(0,i);
            String b = s.substring(i+1);
            
            String c = s.substring(i,i+1);
            if(a.contains(c) || b.contains(c)) continue;
            
            return i;
        }
        return -1;
    }
}
