class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        
        goodNodes(root, res, root.val);
        
        return res[0];
    }
    
    void goodNodes(TreeNode root, int[] res, int pathMax){
        if(root == null) return;
        
        if(root.val >= pathMax) res[0] += 1;
        
        pathMax = Math.max(pathMax, root.val);
        goodNodes(root.left, res,pathMax);
        goodNodes(root.right, res, pathMax);
    }
    
}
