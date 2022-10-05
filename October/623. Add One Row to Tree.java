/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addRow(root,val,depth);
        //return root;
    }
    TreeNode addRow(TreeNode root, int val, int depth){
        int level = 1;
        if(level == depth){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            
           
            return newNode;
        }
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode rp = q.poll();
                if(level == depth - 1) {
                     TreeNode newNode = new TreeNode(val);
                     TreeNode newNode1 = new TreeNode(val);
                     newNode.left = rp.left;
                     newNode1.right = rp.right;
                     
                     rp.left = newNode;
                     rp.right = newNode1;
                }
                if(level >= depth) return root;
                if(rp.left != null) q.add(rp.left);
                if(rp.right != null) q.add(rp.right);
            }
            level++;
        }
        return root;
    }
}
