class Solution {
    String res = "";
    public String tree2str(TreeNode root) {
        fun(root);
        return res;
    }
    
    void fun(TreeNode root){
        if(root == null) return;
        res += root.val;
        if(root.left != null || root.right != null){
            res += "(";
            fun(root.left);
            res += ")";
        }
        if(root.right != null){
            res += "(";
            fun(root.right);
            res += ")";
        }
    }
}
