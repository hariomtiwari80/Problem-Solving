class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];
        return find(s,p,0,0);
    }
    public boolean find(String s,String p,int i,int j){
        if(j==p.length()) return i==s.length();
        if(dp[i][j]!=null) return dp[i][j];
        boolean b=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) b=true;
        boolean ans=false;
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean skip=find(s,p,i,j+2);
            boolean take=false;
            if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) take=find(s,p,i+1,j);
            ans=take || skip;
        }
        else ans=b && find(s,p,i+1,j+1);
        return dp[i][j]=ans;
    }
}
