class Solution {
    public int coinChange(int[] coin, int amt) {
        int n=coin.length;
        int[] dp=new int[amt+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amt;i++){
            int min=Integer.MAX_VALUE;
            for(int x:coin){
                if(x<=i) min=Math.min(min,dp[i-x]);
            }
            if(min!=Integer.MAX_VALUE) dp[i]=1+min;
        }
        if(dp[amt]==Integer.MAX_VALUE) return -1;
        return dp[amt];
    }
}
