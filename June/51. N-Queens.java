class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        solveQueen(mat,0,0,0,n,n,res);
        return res;
    }
    void solveQueen(char[][] mat, int i, int j, int qpsf, int tq,int n,List<List<String>> res){
        if(qpsf == tq) {
        List<String> s = new ArrayList<>();
        for(int k = 0; k < n; k++){
            String a = "";
            for(int l = 0; l < n; l++){
               a += String.valueOf(mat[k][l]);
            }
            s.add(a);
        }
        res.add(new ArrayList<>(s));
        return;
    }
        
        for(int col = 0 ; col < n ; col++){
            j = col;
         
            if(isSafe(mat,i,j) == false) continue;
            
            mat[i][j] = 'Q';
            solveQueen(mat,i + 1,j,qpsf+1,tq,n,res);
            
            mat[i][j] = '.';
            
        }
        
        
    }
    boolean isSafe(char[][] mat, int i, int j){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) return false;
        
        for(int row = i; row >= 0; row--){
            if(mat[row][j] == 'Q') return false;
        }
        for(int col = j; col >= 0; col--){
            if(mat[i][col] == 'Q') return false;
        }
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--){
            if(mat[row][col] == 'Q') return false;
        }
        for(int row = i, col = j; row >= 0 && col < mat[0].length; row--, col++){
            if(mat[row][col] == 'Q') return false;
        }
        return true;
    }
}
