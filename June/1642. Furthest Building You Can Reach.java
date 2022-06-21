class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladder) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       // int cnt = 0;
        int n = heights.length;
        int i = 0;
        int size = ladder;
        for(i = 0; i < n - 1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff < 0){
                continue;
            }
            pq.add(diff);
            if(pq.size() > size){
               int top = pq.poll();
               if(bricks - top >= 0){
                   bricks -= top;
               }
               else{
                   return i;
               }
            }
        }
        return i;
    }
}
