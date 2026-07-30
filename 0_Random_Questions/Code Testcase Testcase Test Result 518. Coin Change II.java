class Solution {
    public int change(int amt, int[] coin) {
        int[] dp=new int[amt+1];
        dp[0]=1;
        for(int x:coin){
            for(int i=x;i<=amt;i++){
                dp[i]+=dp[i-x];
            }
        }
        return dp[amt];
    }
}
