class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < magazine.length(); i++){
            map.put(magazine.substring(i,i+1), map.getOrDefault(magazine.substring(i,i+1),0) + 1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            String key = ransomNote.substring(i, i + 1);
            if(map.getOrDefault(key, 0) == 0){
                return false;
            }
            
            map.put(key, map.get(key) - 1);
        }
        return true;
    }
}
