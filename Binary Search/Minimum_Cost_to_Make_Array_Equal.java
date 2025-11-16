class Solution {
    public long minCost(int[] arr, int[] cost) {
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        for(int x:arr){
            h=Math.max(x,h);
            l=Math.min(l,x);
        }          
        long ans=Long.MAX_VALUE; 
        while(l<=h){
            int m=l+(h-l)/2;
            long c1=find(arr,cost,m);
            long c2=find(arr,cost,m+1);
            if(c1<c2){
                ans=c1;
                h=m-1;
            }
            else l=m+1;
        }       
        return ans;
    }
    public long find(int[] arr,int[] cost,int i){
        long c=0;
        for(int j=0;j<arr.length;j++){
            int t=Math.abs(arr[j]-i);
            c+=(long)t*cost[j];
        }
        return c;
    }
}
