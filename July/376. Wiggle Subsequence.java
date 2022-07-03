class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int n = nums.length;
        if(n < 2) return 1;
        int prevSign = 0;
        int cnt = 0;
        int diff = nums[1] - nums[0];
        if(diff < 0) {
            prevSign = diff;
            cnt = 2;
        }
        if(diff == 0) {
            prevSign = diff;
            cnt = 1;
          
        }
        else{
            prevSign = diff;
            cnt = 2;
        }
        for(int i = 2; i < n; i++){
             int currSign = nums[i] - nums[i-1];
           //  System.out.println(currSign+" "+prevSign+" "+nums[i]);
            if((currSign > 0 && prevSign <= 0) || (currSign < 0 && prevSign >= 0)){
               // System.out.println(nums[i]);
                cnt++;
                prevSign = currSign;
            }

        }
        return cnt;
    }
}
