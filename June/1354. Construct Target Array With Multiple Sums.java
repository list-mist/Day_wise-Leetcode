class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        
        for(int i : target){
            sum += i;
            pq.add(i);
        }
        
        while(!pq.isEmpty() && pq.peek() != 1){
            int x = pq.poll();
            
            sum -= x;
            
            if(sum < 1 || x <= sum) return false;
            
            x = x % sum;
            sum += x;
            if(x == 0){
                pq.add(sum);
            }
            else{
                pq.add(x);
            }
        }
        return true;
   
