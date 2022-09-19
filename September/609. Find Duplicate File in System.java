class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int n = paths.length;
        
        for(int k = 0; k < n; k++){
            String[] str = paths[k].split(" ");
            for(int i = 1; i < str.length; i++){
               String path = str[0] + "/" + str[i];
               String content = "";
               char ch = str[i].charAt(0);
               int j = 0;
               while(j < str[i].length()){
                   ch =  str[i].charAt(j);
                   if(ch == '('){
                       path = str[0] + "/" + str[i].substring(0, j);
                       content = str[i].substring(j + 1, str[i].length() - 1);
                       break;
                   }
                   else{
                       j++;
                   }
               }
               List<String> vals = map.getOrDefault(content, new ArrayList<>());
               vals.add(path);
               map.put(content, vals);

            }
        }
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            if(e.getValue().size() == 1) continue;
            res.add(new ArrayList<>(e.getValue()));
        }
        return res;
    }
}
