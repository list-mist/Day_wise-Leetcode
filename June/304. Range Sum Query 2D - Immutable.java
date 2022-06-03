class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
       this.mat = new int[matrix.length][matrix[0].length];
       this.mat = matrix;
        
        for(int i = 1; i < mat[0].length; i++){
            mat[0][i] += mat[0][i-1];
        }
        for(int i = 1; i < mat.length; i++){
            mat[i][0] += mat[i-1][0];
        }
        for(int i = 1; i < mat.length; i++){
            for(int j = 1; j < mat[0].length; j++){
                mat[i][j] += mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }
      
    }
 
    public int sumRegion(int row1, int col1, int row2, int col2) {
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
