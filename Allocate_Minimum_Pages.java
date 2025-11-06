class Solution {
    public int findPages(int[] arr, int k) {
        if(arr.length<k) return -1;
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
        int c=1,sum=0;
        for(int x:arr){
            sum+=x;
            if(sum>m){
                c++;
                sum=x;
            }
            if(c>k) return false;
        }
        return true;
    }
}
