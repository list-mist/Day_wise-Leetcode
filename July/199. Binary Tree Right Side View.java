class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }
    List<Integer> bfs(TreeNode root){
        List<Integer> lis = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode rp = q.poll();

                if(!lis.contains(level)){
                    res.add(rp.val);
                    lis.add(level);
                }
                if(rp.right != null){
                     q.add(rp.right);
                }
                if(rp.left != null){
                    q.add(rp.left);

                }
            }
            level++;
        }
        
        return res;
    }
}
