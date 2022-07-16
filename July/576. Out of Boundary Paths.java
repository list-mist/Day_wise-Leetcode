class Solution {
    HashMap<String,Long> map;
    int mod = 1000000000 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        map = new HashMap<>();
        int cnt = dfs(m,n,maxMove,startRow, startCol, 0);
        
        return cnt % mod;
    }
    
    int dfs(int m, int n, int maxMove, int startRow, int startCol, int moves){
     
if((startRow >= m || startCol >= n || startRow < 0 || startCol < 0)) return 1;
        if(moves >= maxMove) return 0;
        String key = startRow + ":" + startCol + ":"+moves;
        
        if(map.containsKey(key)) return (int) (map.get(key) % mod );
        
        long cnt = 0;

        long a = (dfs(m, n, maxMove, startRow + 1,startCol,moves + 1)) % mod;
        long b = ( dfs(m, n, maxMove, startRow - 1,startCol,moves + 1))% mod;
        long c = ( dfs(m, n, maxMove, startRow ,startCol + 1,moves + 1))% mod;
        long d = ( dfs(m, n, maxMove, startRow ,startCol - 1,moves + 1))% mod;
        cnt = (a + b + c + d) % mod;
        map.put(key, cnt);
        return (int) cnt ;
        
    }
}
