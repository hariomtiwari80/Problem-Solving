class Solution {
    public int minEatingSpeed(int[] piles, int hr) {
        int n=piles.length,l=1,h=Integer.MIN_VALUE;
        for(int x:piles){
            h=Math.max(x,h);
        }
        int ans=h;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(piles,m,hr)){
                ans=Math.min(ans,m);
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] piles,int m,int hr){
        long t=0;
        for(int x:piles){
            t+=x/m;
            if(x%m!=0) t++;
        }
        return t<=hr;
    }
}
