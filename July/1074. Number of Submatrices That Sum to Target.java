class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m][n];
        
        prefix[0][0] = mat[0][0];
        
        for(int i = 1; i < n; i++){
            prefix[0][i] += prefix[0][i-1] + mat[0][i]; 
        }
        
        for(int i = 1; i < m; i++){
            prefix[i][0] += prefix[i-1][0] + mat[i][0]; 
        }
        
        for(int i = 1; i < m; i++){
           for(int j = 1; j < n; j++){
               prefix[i][j] = (prefix[i-1][j] + prefix[i][j-1] + mat[i][j]) - (prefix[i-1][j-1]);
           }
        }

        int count = 0;
        for(int x1 = 0; x1 < m; x1++){
            for(int y1 = 0; y1 < n; y1++){
                for(int x2 = x1; x2 < m; x2++){
                    for(int y2 = y1; y2 < n; y2++){
                        
                        if(x1 != x2 || y1 != y2){

                            int sum = sumRegion(x1,y1,x2,y2,prefix);
                            if(sum == target) count++;
                    }
                     else{
                          if(mat[x1][y1] == target) {
                              count++;
                         }
                     }
                    }
                   
                }
            }
        }
        
        
        return count;
    }
    public int sumRegion(int row1, int col1, int row2, int col2, int[][] mat) {
        int res = 0;
        if(row1 == 0 && col1 == 0) return mat[row2][col2];
        if(row1 == 0){
            res = mat[row2][col2] - mat[row2][col1-1];
            return res;
        }
        if(col1 == 0){
            res = mat[row2][col2] - mat[row1-1][col2];
            return res;
        }
        int total = mat[row2][col2] - (mat[row1-1][col2] + mat[row2][col1-1] - mat[row1-1][col1-1]);
        return total;
    }
}
