class Solution {
    public int minimizeSum(int[] arr) {
        int n=arr.length;
        if(n==3) return 0;
        Arrays.sort(arr);
        int max1=arr[n-3]-arr[0];
        int max2=arr[n-1]-arr[2];
        int max3=arr[n-2]-arr[1];
        return Math.min(max1,Math.min(max2,max3));
    }
}
