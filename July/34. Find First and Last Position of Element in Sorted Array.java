class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        
        start = getStart(nums,target);
        end = getEnd(nums, target);
        
        int[] ans = new int[2];
        
        ans[0] = start;
        ans[1] = end;
        
        return ans;
       
    }
    
    int getStart(int[] nums, int target){
        int start = -1;
     
        int left = 0, right = nums.length - 1;
         while(left <= right){
            int mid = (right - left)/2 + left;
            
            if(nums[mid] == target){
                start = mid;
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return start;
    }
    int getEnd(int[] nums, int target){
        int end = -1;
     
        int left = 0, right = nums.length - 1;
         while(left <= right){
            int mid = (right - left)/2 + left;
            
            if(nums[mid] == target){
                end = mid;
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return end;
    }
}
