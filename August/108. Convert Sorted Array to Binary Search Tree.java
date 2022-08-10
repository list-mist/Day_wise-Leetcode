class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    TreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        int idx = (start + end)/2;
        if(idx >= nums.length) return null;
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = buildTree(nums, start, idx - 1);
        root.right = buildTree(nums, idx + 1, end);
        
        return root;
    }
}
