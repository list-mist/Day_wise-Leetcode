class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = makeMap(words2);
  
        for(String word : words1){
            boolean flag = true;
       
            if(isSub(word,  map)) ans.add(word);
        }
        
        return ans;
    }
    boolean isSub(String word, HashMap<String,Integer> map){
        
     
        HashMap<String,Integer> map1 = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++){
            String d = word.substring(i,i+1);
            map1.put(d, map1.getOrDefault(d,0)+1);
        }
        for(String t : map.keySet()){
            
            int b = map1.getOrDefault(t, 0);
            
            int c = map.get(t);
            
            if(b < c) return false;
        }
        
        return true;
    }
    HashMap<String,Integer> makeMap(String[] word){
        HashMap<String,Integer> map = new HashMap<>();
        for(String t : word){
            
            HashMap<String,Integer> e = new HashMap<>();
            
            for(char ch : t.toCharArray()){
                String s = String.valueOf(ch);
                e.put(s, e.getOrDefault(s,0)+1);
                
                if(!map.containsKey(s) || e.get(s) > map.get(s)){
                    map.put(s, e.get(s));
                }
            }
        }
        
        return map;
    }
}
