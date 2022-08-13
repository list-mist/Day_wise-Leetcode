class Solution {
    HashMap<String,Integer> wordCount = new HashMap<>();
    public List<Integer> findSubstring(String s, String[] words) {
        
        String res = "";
        
        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word,0) + 1);
            res += word;
        }
        
        
        List<Integer> ans = new ArrayList<>();
        int k = res.length();
        int n = s.length();
        
        for(int i = 0; i + k <= n; i++){
            if(checkStart(i, k, s, words[0].length(), words.length)){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean checkStart(int idx, int k, String s, int wordLen, int n){
        HashMap<String,Integer> map = new HashMap<>(wordCount);
        int used = 0;
        
        for(int i = idx; i < idx + k; i += wordLen){
            String sub = s.substring(i, i + wordLen);
            if(map.containsKey(sub) && map.get(sub) > 0){
                map.put(sub, map.get(sub) - 1);
                used++;
            }
            else{
                break;
            }
        }
        return used == n;
    }
}
