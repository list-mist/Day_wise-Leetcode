class Solution {
    public void rotate(int[][] a) {
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        int i=0,j=n-1;
        int m=0;
        while(i<j){
            if(m<n){
                int temp=a[m][i];
                a[m][i]=a[m][j];
                a[m][j]=temp;
                m++;
            }
            if(m>=n){
                m=0;
                i++;
                j--;
            }
        }
    }
}
