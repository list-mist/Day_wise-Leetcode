class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(isSubTree(root) == false) return null;
        fun(root);
        return root;
    }
    
    boolean isSubTree(TreeNode root){
        
        if(root == null) return false;
        if(root.val == 1) return true;
        return isSubTree(root.left) || isSubTree(root.right);
    }
    void fun(TreeNode root){
        if(root == null) return ;
        
        if(isSubTree(root.left) == false) root.left = null;
        if(isSubTree(root.right) == false) root.right = null;
        
        fun(root.left);
        fun(root.right);
    }
}
