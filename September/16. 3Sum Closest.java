class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closestVal = 0;
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i = 0; i < n - 2; i++){
            int left = i + 1, right = n - 1;
            int val = nums[i];
            
            while(left < right){
                int sum = val + nums[left] + nums[right];
                
                if(sum > target){
                    int diff = sum - target;
                    if(res > diff){
                        res = diff;
                        closestVal = sum;
                        
                        
                    }   
                    right--;
                }
                else{
                    int diff = target - sum;
                    if(res > diff){
                        res = diff;
                        closestVal = sum;
                        
                        
                    } 
                    left++;
                }
            }
        }
        return closestVal;
    }
}
