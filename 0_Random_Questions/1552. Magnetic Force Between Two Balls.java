class Solution {
    public int maxDistance(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int l=1,h=arr[n-1]-arr[0];
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
    public boolean valid(int[] arr,int m,int k){
        int c=1,last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=m){
                c++;
                last=arr[i];
            }
            if(c==k) return true;
        }
        return c>=k;
    }
}
