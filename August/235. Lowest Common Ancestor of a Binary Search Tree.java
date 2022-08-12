class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val) return root;
        if((root.val > p.val && root.val < q.val)) return root;
        if(root.val > q.val && root.val < p.val) return root;
        
        if(root.val > p.val && root.val > q.val){
            return LCA(root.left, p, q);
        }
        return LCA(root.right, p, q);
    }
}
