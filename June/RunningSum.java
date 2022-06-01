class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        res[i] = nums[i];
        for(i = 1; i < nums.length;i++){
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }
}