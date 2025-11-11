class Solution {
    public long maxRunTime(int n, int[] arr) {
        long sum=0;
        for(int x:arr){
            sum+=x;
        }
        Arrays.sort(arr);
        long l=1,h=sum;
        long ans=1;
        while(l<=h){
            long m=l+(h-l)/2;
            if(valid(arr,m,n)){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public boolean valid(int[] arr,long m,int n){
        long t=0;
        for(int x:arr){
            t+=Math.min(x,m);
        }
        return t>=m*n; 
    }
}
