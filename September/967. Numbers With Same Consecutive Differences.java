class Solution {
    int[] arr;
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> lis = new HashSet<>();
        
        arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        
        for(int i = 1; i <= 9; i++) fun(lis, n, k, 0, String.valueOf(i));
        int[] ans = new int[lis.size()];
        int idx = 0;
        
        for(int i : lis) ans[idx++] = i;
        
        return ans;
        
    }
    
    void fun(Set<Integer> res, int n, int k, int i, String num){
        if(num.length() == n) {
            res.add(Integer.parseInt(num));
            return;
        }
        if(num.length() > n) return;
        for(int j = 0; j < arr.length; j++){
            if(Math.abs(Integer.parseInt(num.substring(num.length()-1)) - arr[j]) == k){
                num += arr[j];
                fun(res, n, k, i + 1, num);
                
                num = num.substring(0, num.length() - 1);
            }
            
        }
    }
}
