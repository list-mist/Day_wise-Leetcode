class WordFilter {
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        int idx = 0;
        for(String word : words){
            for(int i = 0; i <= word.length(); i++){
                for(int j = 0; j < word.length(); j++){
                    String str = word.substring(0,i) + "#" + word.substring(j);
                    map.put(str,idx);
                }
            }
            idx++;
        }
    }
    
    public int f(String prefix, String suffix) {
        String str = prefix + "#" + suffix;
        
        return map.getOrDefault(str, -1);
    }
}
