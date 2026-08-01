class Solution {
    public int[] dp;
    public int mincostTickets(int[] day, int[] cost) {
        dp=new int[day.length+1];
        Arrays.fill(dp,-1);
        return solve(day,cost,0);
    }
    public int solve(int[] day,int[] cost,int i){
        if(i>=day.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int k=0;k<3;k++){
            int max=day[i];
            if(k==0) max+=1;
            else if(k==1) max+=7;
            else max+=30;
            int idx=i;
            while(idx<day.length && day[idx]<max) idx++;
            min=Math.min(min,cost[k]+solve(day,cost,idx));
        }
        return dp[i]=min;
    }
}
