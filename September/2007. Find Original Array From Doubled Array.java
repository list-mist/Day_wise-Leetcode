class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(changed);

        for(int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int i = 0;
        for(i = 0; i < n; i++){
            int ele = changed[i];
            if(map.get(ele) == 0) continue;
            if(map.getOrDefault(2 * ele, 0) <= 0) return new int[0];
            if(ele == 0 && map.get(0) <= 1) return new int[0];
            res.add(ele);
            
            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }
        
        int[] ans = new int[n/2];
        for(i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }
}
