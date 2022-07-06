class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if(n == 1 || n == 0) return n;
        int curr = a + b;
        
        for(int i = 2; i < n; i++){
            a = b;
            b = curr;
            curr = a + b;
        }
        return curr;
    }
}
