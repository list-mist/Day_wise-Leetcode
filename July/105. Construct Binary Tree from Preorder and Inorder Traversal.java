class Solution {
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     //  return build(preorder, inorder, 0, inorder.length - 1);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build_tree(preorder, inorder, map);
    }
    TreeNode build(int[] pre, int[] in, int start, int end){
	
         if(start > end || idx > pre.length - 1) return null;
	
         TreeNode root = new TreeNode(pre[idx++]);
         int i = 0;
         for(i = start; i <= end; i++){
            if(in[i] == root.val) break;
         }

          root.left = build(pre, in, start, i - 1);
          root.right = build(pre, in, i + 1, end );

          return root;
   }
   TreeNode build_tree(int[] pre, int[] in, HashMap<Integer,Integer> map){
       TreeNode root = new TreeNode(pre[0]);
       
       Deque<TreeNode> dq = new LinkedList<>();
       dq.push(root);
       for(int i = 1; i < pre.length; i++){
           int peek = dq.peek().val;
           int currVal = pre[i];
           int index = map.get(currVal);
           TreeNode node = new TreeNode(currVal);
           if(index < map.get(peek)){
               dq.peek().left = node;
           }
           else{
               TreeNode top = dq.peek();
               int idx = map.get(top.val);
             //  System.out.println(top.val + " "+idx + " "+node.val+" "+index);
               while(index > idx){
                   top = dq.pop();
                   idx = dq.isEmpty() ? Integer.MAX_VALUE : map.get(dq.peek().val);
               }
              // System.out.println(top.val + " "+idx + " "+node.val+" "+index);
               top.right = node;
           }
           dq.push(node);
       }
       return root;
   }
}
