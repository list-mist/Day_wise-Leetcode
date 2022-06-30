class Solution {
    public int minMoves2(int[] nums) {
       
        Arrays.sort(nums);
        
        int mid = (nums.length-1)/2;
        int n = nums.length;
        int moves = 0;
        for(int i = 0; i < n; i++){
            if(i != mid){
                moves += Math.abs(nums[i] - nums[mid]);
            }
        }
        return moves;
    
    }
}
