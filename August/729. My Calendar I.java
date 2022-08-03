class MyCalendar {
    
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer rp = map.floorKey(start);
        Integer ceil = map.ceilingKey(start);
     
        if(rp != null){
            if(!(rp <= start && map.get(rp) <= start)){
                return false;
            }
            if(end <= map.get(rp)) return false;
        }
        if(ceil != null){
            if((end > ceil && end <= map.get(ceil))){
                return false;
            }
            if(map.get(ceil) <= end) return false;
        }
        map.put(start, end);
        return true;
        
    }
}
