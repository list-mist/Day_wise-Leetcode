class NumArray {
    int[] arr;
    int sum = 0;
    public NumArray(int[] nums) {
        arr = nums;
        
        for(int i : nums) sum += i;
    }
    
    public void update(int index, int val) {
        
        sum -= arr[index];
        arr[index] = val;
        
        sum += val;
    }
    
    public int sumRange(int left, int right) {
       int res = sum;
        
       for(int i = 0; i < left; i++){
           res -= arr[i];
       }
       for(int i = right + 1; i < arr.length; i++){
           res -= arr[i];
       }
        
       return res;
    }
}
