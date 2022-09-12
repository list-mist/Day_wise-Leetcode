class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int score = 0;
        int maxScore = 0;
        int i = 0, j = tokens.length - 1;
        while(i <= j){
            if(power >= tokens[i]){
                score += 1;
                power -= tokens[i++];
            }
            else if(score >= 1){
                score -= 1;
                power += tokens[j--];
            }
            else{
                break;
            }
            maxScore = Math.max(maxScore, score);    
        }
        maxScore = Math.max(maxScore, score);
        
        return maxScore;
    }
}
