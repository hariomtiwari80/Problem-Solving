class Solution {
    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(arr,1,n-1,dp);
    }
    static int solve(int[] arr,int i,int j,int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }
        return dp[i][j]=min;
    }
}
