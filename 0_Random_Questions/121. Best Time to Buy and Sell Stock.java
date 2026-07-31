class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int buy=Integer.MAX_VALUE,profit=0;
        for(int i=0;i<n;i++){
            buy=Math.min(buy,arr[i]);
            profit=Math.max(profit,arr[i]-buy);
        }
        return profit;
    }
}
