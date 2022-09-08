class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        fun(root);
        return ans;
    }
  
    void fun(TreeNode root){
        if(root == null) return;
        fun(root.left);
        ans.add(root.val);
        fun(root.right);
    }
}
