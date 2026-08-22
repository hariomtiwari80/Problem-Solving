class Solution {
    public Integer[][][] dp;
    public int countOfPairs(int[] arr) {
        dp=new Integer[arr.length+1][52][52];
        return find(arr,0,0,51);
    }
    public int find(int[] arr,int i,int pre1,int pre2){
        if(i==arr.length) return 1;
        if(dp[i][pre1][pre2]!=null) return dp[i][pre1][pre2];
        int sum=0;
        for(int j=0;j<=arr[i];j++){
            int curr1=j;
            int curr2=arr[i]-j;
            if(pre1<=curr1 && pre2>=curr2) sum=(sum+find(arr,i+1,curr1,curr2))%1000000007;
        }
        return dp[i][pre1][pre2]=sum;
    }
}
