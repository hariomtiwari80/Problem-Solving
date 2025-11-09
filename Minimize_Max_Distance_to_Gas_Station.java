class Solution {
    public double minMaxDist(int[] arr, int K) {
        int n=arr.length;
        double l=0,h=0;
        for(int i=1;i<n;i++){
            h=Math.max(h,arr[i]-arr[i-1]);
        }
        double ans=h;
        while(h-l>1e-6){
            double m=l+(h-l)/2;
            if(valid(arr,m,K)){
                ans=m;
                h=m;
            }
            else l=m;
        }
        return ans;
    }
    public boolean valid(int[] arr,double m,int k){
        int n=0;
        for(int i=1;i<arr.length;i++){
            double gap=arr[i]-arr[i-1];
            n+=(int)(Math.ceil(gap/m)-1);
        }
        return n<=k;
    }
}
