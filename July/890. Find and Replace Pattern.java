class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
      
        for(String word : words){
            if(matchPattern(word, pattern)){
                res.add(word);
            }
        }
        
        return res;
    }
    
    boolean matchPattern(String word, String pattern){
        
       Map<Character,Character> map1 = new HashMap<>();
       Map<Character,Character> map2 = new HashMap<>();
        
       for(int i = 0; i < word.length(); i++){
           
        if(!map1.containsKey(word.charAt(i))) map1.put(word.charAt(i), pattern.charAt(i));
           
        if(!map2.containsKey(pattern.charAt(i))) map2.put(pattern.charAt(i), word.charAt(i));
         

            if(map1.containsKey(word.charAt(i)) && map1.get(word.charAt(i)) != pattern.charAt(i)) return false;
            if(map2.containsKey(pattern.charAt(i)) && map2.get(pattern.charAt(i)) != word.charAt(i)) return false;
        
              
       }
        return true;
    }
}
