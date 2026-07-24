class Solution {
    public int maximumCandies(int[] arr, long k) {
        int n=arr.length;
        int l=1,h=0;
        for(int x:arr) h=Math.max(h,x);
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,k)){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,long k){
        long c=0;
        for(int x:arr){
            c+=x/m;
            if(c==k) return true;
        }
        return c>=k;
    }
}
