class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int[] freq = new int[10001];
  
        int sum = 0, max = 0;
        int i = 0, j = 0, n = nums.length;
      
        while(j < n){
       
                sum += nums[j];
                freq[nums[j]] += 1;
                
       
           
                while(freq[nums[j]] > 1){
                    sum -= nums[i];
                    freq[nums[i]]--;
                     i++;
                }
           
            max = Math.max(sum,max);
             j++;
        }
        return max;
    }
}
