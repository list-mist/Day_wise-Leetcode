class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

         while(!q.isEmpty()){
            int size = q.size();
             List<Integer> a = new ArrayList<>();
             while(size-- > 0){
                 TreeNode rp = q.poll();
                a.add(rp.val);
                
                if(rp.left != null) q.add(rp.left);
                 if(rp.right != null) q.add(rp.right);
            }
             res.add(new ArrayList<>(a));
        
        }
        dfs(res, root, 0);
        return res;
    }
    void dfs(List<List<Integer>> res, TreeNode root, int level){
        if(root == null) return;
     
        if(res.size() > level){
            res.get(level).add(root.val);
        }else{
            res.add(new ArrayList<>(Arrays.asList(root.val)));
        }
        dfs(res,root.left, level + 1);
        dfs(res,root.right, level + 1);
    }
}
