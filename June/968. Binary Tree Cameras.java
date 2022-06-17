class Solution {
    int cnt = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
      
        int cam = mnCamera(root);
        if(cam == -1) return cnt + 1;
        return cnt;
    }
    
    int mnCamera(TreeNode root){
        if(root == null) return 0;
        
        int left = mnCamera(root.left);
        int right = mnCamera(root.right);
        
        if(left == -1 || right == -1){
            cnt++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 0;
        }
        return -1;
    }
}
