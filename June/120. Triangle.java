class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        return minTotalPath(triangle, n);
    }
    int minTotalPath(List<List<Integer>> triangle, int n){

        int min = Integer.MAX_VALUE;
        int[] nextRow = new int[n];
        int[] currRow = new int[n];
        for(int i = 0; i < triangle.get(n-1).size(); i++){
            nextRow[i] = triangle.get(n-1).get(i);
        }
       
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int first = nextRow[j];
                int second = nextRow[j+1];
                currRow[j] = triangle.get(i).get(j) + Math.min(first,second);
            }
            nextRow = currRow;
        }
        return nextRow[0];
    }
}
