class Solution {
    class custom implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return a.val - b.val;
        }
    }
    class Pair{
        int val, row, col;
        
        Pair(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] mat, int k) {
        
       /* PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                pq.add(mat[i][j]);
            }
        }
        
        int ans = 0;
        
        while(k-- > 0 && pq.isEmpty() == false){
            ans = pq.poll();
        }
        */
        return getKSmallest(mat, k);
    }
    public int getKSmallest(int[][] mat, int k){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom());
        
        for(int i = 0; i < mat[0].length; i++){
            pq.add(new Pair(mat[0][i], 0, i));
        }
        int ans = 0;
        while(pq.size() > 0){
            Pair rp = pq.poll();
            ans++;
            
            if(ans == k){
                return rp.val;
            }
            
            int x = rp.row;
            int y = rp.col;
            
            if(x + 1 < mat.length)
            {
                pq.add(new Pair(mat[x+1][y], x + 1,y));
            }
            
        }
        return ans;
    }
}
