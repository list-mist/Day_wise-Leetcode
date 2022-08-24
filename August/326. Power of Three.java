class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        int power = 3;
        
        long res = 3;
        
        for(int i = 1; i <= n; i++){
            
            if(res == n) return true;
            if(res > n) return false;
            res = (long) Math.pow(power, i);
            
            
        }
        
        return false;
    }
}
