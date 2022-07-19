class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) res.add(new ArrayList<>());
        
        res.get(0).add(1);
        if(numRows == 1) return res;
        
        res.get(1).add(1);
        res.get(1).add(1);
        
        
        for(int i = 2; i < numRows; i++){
            res.get(i).add(1);
            for(int j = 0; j < res.get(i-1).size() - 1; j++){
                int a = res.get(i -1).get(j);
                int b = res.get(i-1).get(j+1);
                int sum = a + b;
                
                res.get(i).add(a+b);  
            }
            res.get(i).add(1);
        }
        
        return res;
    }
}
