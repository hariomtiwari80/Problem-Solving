class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i][0]>arr[j][1]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
