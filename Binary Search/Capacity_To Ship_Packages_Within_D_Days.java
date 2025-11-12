class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int n=arr.length;
        if(n<days) return -1;
        int l=Integer.MIN_VALUE,h=0;
        for(int x:arr){
            l=Math.max(l,x);
            h+=x;
        }
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,days)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,int days){
        int d=1,sum=0;
        for(int x:arr){
            sum+=x;
            if(sum>m){
                d++;
                sum=x;
            }
            if(d>days) return false;
        }
        return true;
    }
}
