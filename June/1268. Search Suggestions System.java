class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){  
            String word = searchWord.substring(0,i+1);
             List<String> a = map.getOrDefault(word,new ArrayList<>());
            for(String p : products){
                if(p.length() < word.length()) continue;
                String pr = p.substring(0,word.length());
           
                if(pr.equals(word)){
                    a.add(p);
                }
            }
            Collections.sort(a);
            if(a.size() > 3) a = a.subList(0,3);
            res.add((a));
        }
        return res;
    }
}
