class Solution {
    public int maximumLength(int[] arr, int k) {
        int n=arr.length;
        int[][] dp=new int[k][n];
        for(int[] a:dp) Arrays.fill(a,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int r=(arr[i]+arr[j])%k;
                dp[r][i]=Math.max(dp[r][i],1+dp[r][j]);
                max=Math.max(max,dp[r][i]);
            }
        }
        return max;
    }
}
