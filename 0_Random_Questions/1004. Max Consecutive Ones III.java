class Solution {
    public int longestOnes(int[] arr, int k) {
        int n=arr.length;
        int l=0,z=0,max=Integer.MIN_VALUE;
        for(int r=0;r<n;r++){
            if(arr[r]==0) z++;
            if(z>k){
                max=Math.max(max,r-l);
                while(arr[l]!=0){
                    l++;
                }
                l++;
                z--;
            }
        }
        max=Math.max(max,n-l);
        return max;
    }
}
