class Solution {
    public int maximizeSum(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        for(int x:arr) max=Math.max(max,x);
        int ans=0;
        for(int i=0;i<k;i++){
            ans+=max;
            max++;
        }
        return ans;
    }
}
