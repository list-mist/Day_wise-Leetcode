class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p , q);
    }
    
    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        
        if(root == p || root == q) return root;

        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right, p , q);
        
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
}
