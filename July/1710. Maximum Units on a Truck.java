class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new custom());
        
        int cost = 0;
        
        for(int i = 0; i < boxTypes.length; i++){
            int size = boxTypes[i][0];
            int units = boxTypes[i][1];
            
            if(size > truckSize){
                int partTaken = truckSize % size;
                truckSize -= partTaken;
                cost += partTaken * units;
               
            }else{
                truckSize -= size;
                cost += size * units;
            }
        }
        return cost;
    }
    class custom implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return b[1] - a[1];
        }
    }
}
