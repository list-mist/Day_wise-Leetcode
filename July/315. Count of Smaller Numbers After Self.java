class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

         ArrayList<Integer> arr = new ArrayList<Integer>();
         for(int i = 0; i < nums.length; i++){
             arr.add(nums[i]);
         }
        
        Collections.sort(arr);
       
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int idx = binarySearch(arr,nums[i]);
            ans.add(idx);
            
            arr.remove(idx);
            
        }
        return ans;
    }
    
    int binarySearch(ArrayList<Integer> nums, int target){
        int cnt = 0;
        
        int i = 0;
        int j = nums.size() - 1;
        int res = -1;
        while(i <= j){
            
            int mid = (j - i)/2 + i;
            
            if(nums.get(mid) > target) j = mid - 1;
            else if(nums.get(mid) < target) i = mid + 1;
            
            else{
                res = mid;
                j = mid - 1;
            }
            
            
        }
        return res;
        
    }
}
