class Solution {
    public int smallestDivisor(int[] arr, int t) {
        int l=1,h=-1;
        for(int x:arr) h=Math.max(x,h);
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,t)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,int t){
        int c=0;
        for(int x:arr){
            c+=(x/m);
            if(x%m!=0) c++;
            if(c>t) return false; 
        }
        return c<=t;
    }
}
