class Solution {
    public Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new Integer[triangle.size()+1][triangle.size()+1];
        return triangle.get(0).get(0)+solve(triangle,1,0);
    }
    public int solve(List<List<Integer>> l,int i,int j){
        if(i==l.size()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int take1=l.get(i).get(j)+solve(l,i+1,j);
        int take2=l.get(i).get(j+1)+solve(l,i+1,j+1);
        return dp[i][j]=Math.min(take1,take2);
    }
}
