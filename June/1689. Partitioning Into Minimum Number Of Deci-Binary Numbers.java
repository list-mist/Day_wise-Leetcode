class Solution {
    public int minPartitions(String n) {
       
        int maxNum = 0;
        for(char ch : n.toCharArray()){
            maxNum = Math.max(Integer.parseInt(String.valueOf(ch)), maxNum);
        }
        return maxNum;
    }
}
