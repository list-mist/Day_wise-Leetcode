class Solution {
    int count = 0;
    HashMap<Integer,Integer> map;
    public int pseudoPalindromicPaths (TreeNode root) {
        map = new HashMap<>();
       
        countPalindrome(root, "", new HashSet<>());
        return count;
    }
    void countPalindrome(TreeNode root, String path, Set<Integer> set){
        if(root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if(root.left == null && root.right == null){
            int odd = 0;
            for(int t : map.values()) {
                if(t % 2 != 0) odd += 1;
            }
             if(odd <= 1) count += 1;
        }
        countPalindrome(root.left, path, set);
        countPalindrome(root.right, path, set);
        
        map.put(root.val, map.get(root.val) - 1);
    }
}
