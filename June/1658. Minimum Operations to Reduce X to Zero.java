class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        if(nums[0] == x) return 1;
        prefix[1] = nums[0];
        int minOper = Integer.MAX_VALUE;
        for(int i = 2; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1]; 
            if(prefix[i] == x){
                minOper = i;
            }
        }
        int t = prefix[n];
        int i = 0, j = 1;
        int sum = 0;
        if(x > t) return -1;
        while(j < n){
           
            sum = t - prefix[j] + prefix[i];

            if(sum == x){
                minOper = Math.min(minOper,n-j+i);
                j++;
            }
            else if(x < sum){
                j++;
            }
            else if(x > sum){
                i++;
            }
        }
        if(minOper == Integer.MAX_VALUE) return -1;
        return minOper;
    }
}
