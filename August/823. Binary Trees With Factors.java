class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        HashMap<Integer,Long> map = new HashMap<>();
        int mod = (int)Math.pow(10,9) + 7;
        for(int i : arr){
            map.put(i, (long) 1);
        }
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 1; i < n; i++){
            long count = 0;
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){
                    if(map.containsKey(arr[i]/arr[j])){
                        count = (count + (map.get(arr[j]) * map.get(arr[i]/arr[j]) )) ;
                    }
                }
            }
            map.put(arr[i], (map.get(arr[i]) + count) );
        }
        long sum = 0;
        
        for(long i : map.values()) sum = ( sum + i) ;
        return  (int)(sum % mod);
    }
}
