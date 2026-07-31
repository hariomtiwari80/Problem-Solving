class Solution {
    public int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp=new int[s1.length()+1][s2.length()+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return find(s1,s2,0,0);
    }
    public int find(String s1,String s2,int i,int j){
        if(i==s1.length() && j==s2.length()) return 0;
        if(i==s1.length()){
            int t=0;
            while(j<s2.length()){
                t+=(int)(s2.charAt(j++));
            }
            return t;
        }
        if(j==s2.length()){
            int t=0;
            while(i<s1.length()){
                t+=(int)(s1.charAt(i++));
            }
            return t;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=find(s1,s2,i+1,j+1);
        else{
            int take1=(int)(s1.charAt(i))+find(s1,s2,i+1,j);
            int take2=(int)(s2.charAt(j))+find(s1,s2,i,j+1);
            return dp[i][j]=Math.min(take1,take2);
        }
    }
}
