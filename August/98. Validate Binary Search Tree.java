class Solution {
    TreeNode node = null;
    TreeNode next = null;
    public boolean isValidBST(TreeNode root) {

        boolean[] ans = new boolean[1];
        ans[0] = true;
        checkBST(root, null, ans);
      
        return ans[0];
    }
    
 
    
    void checkBST(TreeNode root, TreeNode prev, boolean[] res){
        if(root == null) return;
        
        checkBST(root.left, root, res);
        
        if(node == null) node = root;
        
        else if(node != null){
            next = root;
            if(node.val >= next.val) res[0] = false;
            node = next;
        }

        checkBST(root.right, root, res);
    }
}
