class Solution {
    public int totalNQueens(int n) {
        int[][] mat = new int[n][n];
        int[] res = new int[1];
        totalQueen(mat,0,0,n,n,0,res);
        return res[0];
    }
    void totalQueen(int[][] mat, int i, int j, int n, int tq, int qpsf, int[] res){
        if(qpsf == tq){
            res[0] += 1;
            return;
        }
        for(int col = 0; col < n; col++){
           j = col;
           
           if(!isSafe(mat,i,j,n)) continue;
           mat[i][j] = 1;
           totalQueen(mat,i+1,j,n,tq,qpsf+1,res);
           
           mat[i][j] = 0;
           
        }
    }
    boolean isSafe(int[][] mat, int row, int col, int n){
        if(row >= n || col >= n || col < 0 || row < 0) return false;
        
        for(int i = 0; i < n; i++){
            if(mat[i][col] == 1 || mat[row][i] == 1) return false;
        }
        
        
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(mat[i][j] == 1) return false;
        }
        for(int i = row, j = col; i >= 0 && j < n; i--, j++){
            if(mat[i][j] == 1) return false;
        }
        return true;
    }
}
