class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int n=arr.length,mi=arr[0].length;
        int l=0,h=mi-1;
        while(l<=h){
            int m=l+(h-l)/2;
            int i=findMax(arr,m);
            int left=-1,right=-1;
            if(m-1>=l) left=arr[i][m-1];
            if(m+1<=h) right=arr[i][m+1];
            if(arr[i][m]>left && arr[i][m]>right) return new int[]{i,m};
            else if(left>arr[i][m] && left>right) h=m-1;
            else l=m+1;
        }
        return new int[]{-1,-1};
    }
    public int findMax(int[][] arr,int m){
        int max=-1,idx=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][m]>max){
                max=arr[i][m];
                idx=i;
            }
        }
        return idx;

    }
}
