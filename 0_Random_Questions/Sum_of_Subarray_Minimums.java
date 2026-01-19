class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int min=arr[i];
            ans+=min;
            for(int j=i+1;j<n;j++){
                min=Math.min(min,arr[j]);
                ans+=min;
            }
        }
        return (int)(ans %1_000_000_007);
    }
}

-------------------------------------------------------

