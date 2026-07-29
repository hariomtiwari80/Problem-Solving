class Solution {
    public int MOD=1000000007;
    public int minAbsoluteSumDiff(int[] arr1, int[] arr2) {
        int n=arr1.length;
        long sum=0;
        int max=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=arr1[i];
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            sum+=Math.abs(arr1[i]-arr2[i]);
        }
        for(int i=0;i<n;i++){
            int intial=Math.abs(arr1[i]-arr2[i]);
            int t=intial;
            int idx=lower(arr,arr2[i]);
            if(idx==n) t=Math.min(t,Math.abs(arr[idx-1]-arr2[i]));
            else if(idx==0) t=Math.min(t,Math.abs(arr[idx]-arr2[i]));
            else{
                t=Math.min(t,Math.abs(arr[idx-1]-arr2[i]));
                t=Math.min(t,Math.abs(arr[idx]-arr2[i]));
            }
            if(t!=intial) max=Math.max(max,intial-t);
        }
        sum=(sum-max)%MOD;
        return (int)sum;
    }
    public int lower(int[] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
