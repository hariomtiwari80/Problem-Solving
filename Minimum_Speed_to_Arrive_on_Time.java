class Solution {
    public int minSpeedOnTime(int[] arr, double hr) {
        int l=1,h=10000000;
        int ans=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,hr)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,double hr){
        double t=0;
        for(int i=0;i<arr.length-1;i++){
            t+=Math.ceil((double)arr[i]/m);
        }
        t+=(double)arr[arr.length-1]/m;
        return t<=hr;
    }
}
