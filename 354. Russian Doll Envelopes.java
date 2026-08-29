class Solution {
    public int maxEnvelopes(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            else return Integer.compare(a[0],b[0]);
        });
        int[] dp=new int[n];
        int size=0;
        for(int i=0;i<n;i++){
            int lb=lower(dp,arr[i][1],size);
            dp[lb]=arr[i][1];
            if(lb==size) size++;
        }
        return size;
    }
    public int lower(int[] arr,int t,int n){
        int l=0,h=n;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
