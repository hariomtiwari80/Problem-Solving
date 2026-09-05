class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int sum1=0,sum2=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum1=Math.max(arr[i],sum1+arr[i]);
            max=Math.max(max,sum1);
            sum+=arr[i];
            sum2=Math.min(arr[i],sum2+arr[i]);
            min=Math.min(min,sum2);
        }
        if(sum==min) return max;
        int ans=sum-min;
        if(max>ans) return max;
        return ans;
    }
}
