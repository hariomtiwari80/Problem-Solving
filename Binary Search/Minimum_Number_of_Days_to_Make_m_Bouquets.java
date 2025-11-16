class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n=arr.length;
        if(n<m*k) return -1;
        int ans=-1;
        int l=1,h=0;
        for(int x:arr){
            h=Math.max(h,x);
        }
        while(l<=h){
            int mi=l+(h-l)/2;
            if(valid(arr,mi,m,k)){
                ans=mi;
                h=mi-1;
            }
            else l=mi+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int mi,int m,int k){
        int c=0,sum=0,i=0;
        while(i<arr.length){
            if(arr[i]<=mi){
                sum++;
            }
            else sum=0;
            if(sum==k){
                c++;
                sum=0;
            }
            i++;
        }
        return c>=m;
    }
}
