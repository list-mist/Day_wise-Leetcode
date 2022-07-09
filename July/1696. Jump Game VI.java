class Solution {
    public int maxResult(int[] nums, int k) {
        return getMaxVal(nums, k);
    }
    class custom implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return b[1] - a[1];
        }
    }
    int getMaxVal(int[] nums, int k){
        int n = nums.length;
     
        int[] dp = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new custom());
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!pq.isEmpty() && pq.peek()[0] > i + k ){
                pq.poll();
            }
            dp[i] = nums[i];
     
            if(pq.size() > 0){
          
                dp[i] += pq.peek()[1];
            }
            
            pq.add(new int[]{i, dp[i]});
        }
        return dp[0];
    }
}
