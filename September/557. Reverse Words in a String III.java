class Solution {
    public String reverseWords(String s) {
        String rev = "";
        
        String[] str = s.split(" ");
        
        for(String t : str){
            rev += reverse(t) + " ";
        }
        
        return rev.substring(0, rev.length() - 1);
    }
    
    String reverse(String s){
        String res = "";
        
        for(int i = s.length() - 1; i >= 0; i--){
            res += String.valueOf(s.charAt(i));
        }
        return res;
    }
}
