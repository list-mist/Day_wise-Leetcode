class Solution {
    
    int mod = 1_000_000_007;
    HashMap<String,Long> dp = new HashMap<>();
    public int countVowelPermutation(int n) {
        HashMap<String,String> map = new HashMap<>();
        
        map.put("a", "e");
        map.put("e", "ai");
        map.put("i", "aeou");
        map.put("o", "iu");
        map.put("u", "a");
        long sum = 0;
        for(String t : map.keySet()){
            sum = (sum + countVowel(n-1, t, map)) % mod;
        }
        return (int)sum;
    }
    
    long countVowel(int n, String prev, HashMap<String,String> map){
        if(n == 0) return 1;
        String key = map.get(prev) + " : " + n;
        if(dp.containsKey(key)) return dp.get(key);
        String t = map.get(prev);
        
        long res = 0;
        for(int i = 0; i < t.length(); i++){
            String s = t.substring(i,i+1);
            res = (res + countVowel(n - 1, s, map)) % mod;
        }
        dp.put(key, res % mod );
        return res;
    }   
}
