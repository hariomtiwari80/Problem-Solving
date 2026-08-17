public class Solution {
    public int MinimumSum(int[] arr) {
        int n=arr.Length;
        if(n<3) return -1;
        int[] pre=new int[n];
        int[] suf=new int[n];
        pre[0]=arr[0];
        suf[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pre[i]=Math.Min(pre[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.Min(suf[i+1],arr[i]);
        }
        int ans=int.MaxValue;
        for(int i=1;i<n-1;i++){
            if(arr[i]>pre[i-1] && arr[i]>suf[i+1]){
                ans=Math.Min(ans,arr[i]+pre[i-1]+suf[i+1]);
            }
        }
        if(ans==int.MaxValue) return -1;
        return ans;
    }
}
