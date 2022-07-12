class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        int k = 4;
        for(int i : nums) sum += i;
        
        if(sum % k != 0) return false;
        
        int target = sum/k;
        Arrays.sort(nums);
     
        return canPart(nums,k, 0, target, new int[k]);
    }
     boolean canPart(int[] nums, int k, int index, int target,int[] res){
        if(index >= nums.length){
            return true;
        }
    
        for(int i = 0; i < k; i++){
            
            if((res[i] + nums[index] > target) || (i >= 1 && res[i] == res[i-1])) continue;
            
            res[i] += nums[index];
            
            if(canPart(nums, k, index+1, target, res)) return true;
            
            res[i] -= nums[index];
        }
        return false;
    }
}
