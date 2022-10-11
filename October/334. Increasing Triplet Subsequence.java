class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, Integer.MAX_VALUE);
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minVal = Math.min(minVal, nums[i]);
            left[i] = minVal;
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            maxVal = Math.max(maxVal, nums[i]);
            right[i] = maxVal;
        }
        for(int i = 1; i < n; i++){
            if(nums[i] > left[i] && nums[i] < right[i]) return true;
        }
        return false;
    }
}
