class Solution {
    public int splitArray(int[] arr, int k) {
        int n=arr.length;
        int l=Integer.MIN_VALUE,h=0;
        for(int x:arr){
            l=Math.max(l,x);
            h+=x;
        }
        int ans=h;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,k)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,int k){
        int sub=1,sum=0;
        for(int x:arr){
            sum+=x;
            if(sum>m){
                sum=x;
                sub++;
            }
            if(sub>k) return false;
        }
        return true;
    }
}
