class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String word : words){
            String transformation = "";
            
            for(int i = 0; i < word.length(); i++){
                transformation += String.valueOf(str[word.charAt(i) - 'a']);
            }
            map.put(transformation,0);
        }
        
        return map.size();
    }
}
