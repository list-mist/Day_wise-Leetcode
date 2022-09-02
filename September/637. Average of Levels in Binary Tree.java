class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        //res.add((double)root.val);
        int level = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            double sum = 0;
            int cnt = 0;
            while(size-- > 0){
                
                TreeNode rp = q.poll();    
              //  System.out.println(rp.val);
                sum += rp.val;
                cnt++;
                
                TreeNode left = rp.left;
                TreeNode right = rp.right;
                
                if(left != null) {
                    //sum += left.val;
                    q.add(left);
                   // cnt += 1;
                }
                if(right != null) {
                   // sum += right.val;
                    q.add(right);
                    //cnt += 1;
                }
                if(cnt != 0)
                {
                    if(level < res.size()){
                        res.set(level, sum/cnt);
                    }
                    else{
                        res.add(sum/cnt);
                    }
                }
            }
            level++;
        }
        return res;
    }
}
