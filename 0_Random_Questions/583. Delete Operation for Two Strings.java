class Solution {
    public Integer[][] dp;
    public int minDistance(String s1, String s2) {
        dp=new Integer[s1.length()+1][s2.length()+1];
        return find(s1,s2,0,0);
    }
    public int find(String s1,String s2,int i,int j){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return find(s1,s2,i+1,j+1);
        int min=Integer.MAX_VALUE;
        int t1=1+find(s1,s2,i+1,j);
        int t2=1+find(s1,s2,i,j+1);
        min=Math.min(t1,t2);
        return dp[i][j]=min;
    }
}
