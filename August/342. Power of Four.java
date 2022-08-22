class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        int power =  4;
        long res = 4;
        for(int i = 1; i < n; i++){
            if(res == n) return true;
            if(res > n) return false;
            
            res = (long)Math.pow(power,i);
        }
        return false;
    }
}
