class Solution {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return ;
        Stack<TreeNode> st = new Stack<>();
        dfs(st, root);
        TreeNode c = new TreeNode(0);
        TreeNode curr = root;
        st.pop();
        while(!st.isEmpty()){
            curr.right = new TreeNode(st.pop().val);
            curr.left = null;
            curr = curr.right;
        }
       
    }
    void dfs(Stack<TreeNode> st, TreeNode root){
        if(root == null) return;
        
        dfs(st,root.right);
        dfs(st,root.left);
        
        st.push(root);
    }
}
