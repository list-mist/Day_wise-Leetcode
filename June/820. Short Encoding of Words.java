class Solution {
    public int minimumLengthEncoding(String[] words) {
        return revWords(words);
    }
    String reverse(String word){
        String res = "";
        for(int i = word.length() - 1; i >= 0; i--){
            res += word.substring(i,i+1);
        }
        return res;
    }
    int revWords(String[] words){
        List<String> res = new ArrayList<>();
        for(String t : words){
            res.add(reverse(t));
        }
        Collections.sort(res);
        int cnt = 0;
        for(int i = 1; i <= res.size(); i++){
            String s = res.get(i-1);
            while(i < res.size() && res.get(i).startsWith(s)){
                s = res.get(i);
                i++;
            }
            cnt += res.get(i-1).length() + 1;
        }
        return cnt;
    }
}
