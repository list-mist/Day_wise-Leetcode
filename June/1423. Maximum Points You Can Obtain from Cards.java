class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int[] prefix = new int[n];
        prefix[0] = card[0];
        
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + card[i];
        }
        int totalSum = prefix[n-1];
        int maxScore = 0;
        if(n - k - 1 >= 0){
           maxScore =  totalSum - prefix[n-k-1];
        }
        for(int left = n - k, right = 0; left < n && right < k; left++, right++){
            int t = totalSum - (prefix[left]) + prefix[right];
            maxScore = Math.max(maxScore,t);
        }
        
        return maxScore;
    }
}
