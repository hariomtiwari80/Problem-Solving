class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        if(n<3) return 0;
        int[] dp=new int[n];
        int ans=0;
        if(arr[1]-arr[0]==arr[2]-arr[1]) dp[2]=1;
        ans+=dp[2];
        for(int i=3;i<n;i++){
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        return ans;
    }
}
