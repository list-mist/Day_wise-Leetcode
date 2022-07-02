class Solution {
    public int maxArea(int h, int w, int[] hC, int[] vC) {
    
        long mod = (long)1e9 + 7;
        Arrays.sort(hC);
        Arrays.sort(vC);
        
        long n = h % mod;
        long m = w % mod;
        long diffInY = Math.max(hC[0],(n - hC[hC.length - 1])) ;
        for(int i = 0; i < hC.length - 1; i++){
            diffInY = (Math.max(diffInY, hC[i+1] - hC[i])) ;
        }
        long diffInX = Math.max(vC[0],(m - vC[vC.length - 1]));
        
        for(int i = 0; i < vC.length - 1; i++){
            diffInX = (Math.max(diffInX, vC[i+1] - vC[i])) % mod;
        }
        return (int) ((diffInX * diffInY) % mod);
    }
}
