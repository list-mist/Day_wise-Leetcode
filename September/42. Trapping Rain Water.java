class Solution {
    public int trap(int[] height) {
        int ans=0;
        int left_max=0,right_max=0;
        int l=0,h=height.length-1;
        while(l<=h){
            if(height[l]<=height[h]){
                if(height[l]>left_max){
                   left_max=height[l];
                }
                else{
                    ans+=left_max-height[l];
                }
                l++;
            }
            else{
                if(height[h]>right_max){
                    right_max=height[h];
                }
                else{
                     ans+=right_max-height[h];
                }
                h--;
            }

        }
        return ans;
    }
}
