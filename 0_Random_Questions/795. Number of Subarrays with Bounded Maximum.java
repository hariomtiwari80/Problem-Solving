class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int n=arr.length;
        int[] dp=new int[n];
        int temp=0,ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]>right){
                temp=0;
            }
            else if(arr[i]>=left && arr[i]<=right){
                temp++;
                dp[i]=temp;
            }
            else{
                if(i>0) dp[i]=dp[i-1];
                temp++;
            }
        }
        for(int i=0;i<n;i++) ans+=dp[i];
        return ans;
    }
}
