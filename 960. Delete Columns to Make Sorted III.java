class Solution {
    public int minDeletionSize(String[] arr) {
        int n=arr[0].length();
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(check(arr,i,j)){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return n-max;
    }
    public boolean check(String[] arr,int i,int j){
        for(int k=0;k<arr.length;k++){
            String s=arr[k];
            if(s.charAt(i)<s.charAt(j)) return false;
        }
        return true;
    }
}
