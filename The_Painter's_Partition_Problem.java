class Solution {
    public int minTime(int[] arr, int k) {
        int n=arr.length;
        if(n<k) return -1;
        int l=Integer.MIN_VALUE,h=0;
        for(int x:arr){
            l=Math.max(x,l);
            h+=x;
        }
        int ans=0;
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
        int temp=1,sum=0;
        for(int x:arr){
            sum+=x;
            if(sum>m){
                sum=x;
                temp++;
            }
            if(temp>k) return false;
        }
        return true;
    }
}
