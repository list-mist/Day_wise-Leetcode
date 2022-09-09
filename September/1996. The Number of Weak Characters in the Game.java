class Solution {
    public int numberOfWeakCharacters(int[][] a) {
        
       Arrays.sort(a,new custom());
       int max=a[a.length-1][1];
     
       int count=0;
       for(int i=a.length-2;i>=0;i--){
           if(max>a[i][1] ){
               count++;
           }
            else{
               max=a[i][1];
              
           }
       }
       return count;
    }
    class custom implements Comparator<int[]>{
        public int compare(int[] o1, int[] o2) {
            if(o1[0]==o2[0]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        }
    }
}
