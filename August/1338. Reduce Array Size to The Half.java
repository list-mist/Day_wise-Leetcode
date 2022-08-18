class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : arr) map.put(i, map.getOrDefault(i,0) + 1);
        
        int[] freq = new int[map.size()];
        
        int idx = 0;
        for(int i : map.values()) freq[idx++] = i;
        Arrays.sort(freq);
        
        int ans = 0;
        int n = arr.length;
        int target = n/2;
        int count = 0;
        for(int j = freq.length - 1; j >= 0; j--){
            int i = freq[j];
            if(count < target){
                count += i;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}
