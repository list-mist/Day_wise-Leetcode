class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        
        int rows = 0;
        int col = mat[0].length - 1;
        
        while(rows < mat.length){
            
            if(col < 0) break;
            
            if(mat[rows][col] == target) return true;
            
            if(mat[rows][col] > target){
                col--;
            }
            else if(mat[rows][col] < target){
                
                rows++;
            }
        }
        return false;
    }
}
