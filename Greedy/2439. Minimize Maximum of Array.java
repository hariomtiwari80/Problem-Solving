class Solution {
    public int minimizeArrayValue(int[] arr) {
        int n=arr.length;
        int l=1,h=-1;
        for(int x:arr) h=Math.max(h,x);
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m){
        if(arr[0]>m) return false;
        long c=0;
        for(int x:arr){
            c+=(m-x);
            if(c<0) return false;
        }
        return true;
    }
}
