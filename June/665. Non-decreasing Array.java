class Solution {
    public boolean checkPossibility(int[] nums) {
         int modified = 0;
         int n = nums.length;
         for(int i = 1; i < n; i++){
             if(nums[i-1] > nums[i]){
                 if(modified > 1) return false;
                 if(i - 2 >= 0 && nums[i-2] > nums[i]){
                     nums[i] = nums[i-1];
                 }
                 else{
                     nums[i-1] = nums[i];
                 }
                 modified++;
             }
         }
        return modified <= 1;
    }
    
}
