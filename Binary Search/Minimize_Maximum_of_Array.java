class Solution {
    public int minimizeArrayValue(int[] arr) {
        int l=0,h=Integer.MIN_VALUE;
        for(int x:arr){
            h=Math.max(x,h);
        }
        int ans=h;
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
        long c=0;
        for(int i=arr.length-1;i>=0;i--){
            long temp=arr[i]+c;
            if(temp>m){
                c=temp-m;
            }
            else c=0;
        }
        return c==0;
    }
}
