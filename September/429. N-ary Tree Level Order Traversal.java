class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                Node rp = q.poll();
                
                if(res.size() <= level){
                    res.add(new ArrayList<>());
                    
                }
                res.get(level).add(rp.val);
                List<Node> child = rp.children;
                for(Node c : child){
                    q.add(c);
                }
            }
            level++;
        }
        return res;
        
    }
}
