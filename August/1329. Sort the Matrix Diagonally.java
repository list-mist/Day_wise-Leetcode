class Solution {
    public int[][] diagonalSort(int[][] mat) {
       HashMap<Integer,List<Integer>> map = new HashMap<>();
       int rows = mat.length, cols = mat[0].length;
        
       for(int i = 0; i < rows; i++){
           int diff = 0;
           List<Integer> c = new ArrayList<>();
           for(int j = 0; j < cols; j++){
                diff = (i - j);
                c = map.getOrDefault(diff + cols, new ArrayList<>());
               
                c.add(mat[i][j]);
                Collections.sort(c);
               
                map.put(diff + cols, c);
           }
           
          
       }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = map.get(i - j + cols).remove(0);
            } 
        }
        
        return mat;
    }
    
}
