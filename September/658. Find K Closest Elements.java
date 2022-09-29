class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int dist = Math.abs(x - arr[i]);
            List<Integer> vals = map.getOrDefault(dist, new ArrayList<>());
            
            vals.add(arr[i]);
            
            map.put(dist, vals);
        }
        for(Map.Entry<Integer,List<Integer>> e : map.entrySet()){
            List<Integer> vals = e.getValue();
            for(int i : vals){
                if(res.size() < k) res.add(i);
                else{
                    break;
                }
            }
            
        }
      
        Collections.sort(res);
        return res;
    }
}
