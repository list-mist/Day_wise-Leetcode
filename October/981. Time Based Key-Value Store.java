class TimeMap {
    HashMap<String, List<Integer>> keys;
    HashMap<String, List<String>> vals;
    public TimeMap() {
        keys = new HashMap<>();
        vals = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> t = keys.getOrDefault(key, new ArrayList<>());
        List<String> v = vals.getOrDefault(key, new ArrayList<>());
        
        t.add(timestamp);
        v.add(value);
        
        keys.put(key, t);
        vals.put(key, v);
    }
    
    public String get(String key, int timestamp) {
        if(keys.getOrDefault(key, new ArrayList<>()).size() == 0) return "";
        
        int left = 0, right = keys.get(key).size() - 1;
        int idx = -1;
        List<Integer> time = keys.get(key);
        while(left <= right){
            int mid = (left + right)/2;
            
            if(time.get(mid) <= timestamp){
                idx = Math.max(idx, mid);
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(vals.getOrDefault(key, new ArrayList<>()).size() < idx || idx == -1) return "";
        return vals.get(key).get(idx);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
