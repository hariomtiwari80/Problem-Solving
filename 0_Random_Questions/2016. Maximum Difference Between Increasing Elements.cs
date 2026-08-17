public class Solution {
    public int MaximumDifference(int[] arr) {
        int n=arr.Length;
        int ans=-1;
        int min=int.MaxValue;
        for(int i=0;i<n;i++){
            if(arr[i]>min){
                ans=Math.Max(ans,arr[i]-min);
            }
            min=Math.Min(min,arr[i]);
        }
        return ans;
    }
}
