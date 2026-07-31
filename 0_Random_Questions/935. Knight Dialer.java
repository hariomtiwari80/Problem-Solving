class Solution {
    public int MOD=1000000007;
    public Integer[][][] dp;
    public int knightDialer(int n) {
        dp=new Integer[4][3][n];
        long sum=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                sum+=solve(i,j,n-1);
            }
        }
        sum+=solve(3,1,n-1);
        return (int)(sum%MOD);
    }
    public int solve(int i,int j,int n){
        if(i<0 || j<0 || i>3 || j>2) return 0;
        if((i==3 && j==0) || (i==3 && j==2)) return 0;
        if(n==0) return 1;
        if(dp[i][j][n]!=null) return dp[i][j][n];
        long ans=0;
        ans+=solve(i-2,j-1,n-1);
        ans+=solve(i-2,j+1,n-1);
        ans+=solve(i+2,j-1,n-1);
        ans+=solve(i+2,j+1,n-1);
        ans+=solve(i-1,j-2,n-1);
        ans+=solve(i+1,j-2,n-1);
        ans+=solve(i-1,j+2,n-1);
        ans+=solve(i+1,j+2,n-1);
        return dp[i][j][n]=(int)(ans%MOD);
    }
}
