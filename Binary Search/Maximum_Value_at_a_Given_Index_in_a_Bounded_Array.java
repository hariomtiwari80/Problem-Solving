class Solution {
    public int maxValue(int n, int idx, int max) {
        int l=1,h=max;
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(n,idx,max,m)){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public boolean valid(int n,int idx,int max,int m){
        long maxr=n-idx-1,maxl=idx;
        long t=m-1;
        long sumr=0,suml=0;
        if(maxr<=t){
            sumr=(long)((t)*(t+1))/2 - (long)((t-maxr)*(t-maxr+1))/2;
        }
        else{
            sumr=(long)((t)*(t+1))/2 + (long)(maxr-t);
        }
        if(maxl<=t){
            suml=(long)((t)*(t+1))/2 - (long)((t-maxl)*(t-maxl+1))/2;
        }
        else{
            suml=(long)((t)*(t+1))/2 + (long)(maxl-t);
        }
        return (sumr+m+suml)<=(long)(max);
    }
}
