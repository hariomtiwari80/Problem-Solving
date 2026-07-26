class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int[] freq=new int[26];
            int dis=0,max=0;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                if(freq[ch-'a']==0) dis++;
                freq[ch-'a']++;
                if(freq[ch-'a']>max) max=freq[ch-'a'];
                int len=j-i+1;
                if(dis*max==len){
                    dp[i]=Math.min(dp[i],1+dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}
