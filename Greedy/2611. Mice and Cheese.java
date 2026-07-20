class Solution {
    public int miceAndCheese(int[] arr1, int[] arr2, int k) {
        int n=arr1.length;
        int[][] diff=new int[n][2];
        for(int i=0;i<n;i++){
            diff[i][0]=arr1[i]-arr2[i];
            diff[i][1]=i;
        }
        Arrays.sort(diff,(a,b)->Integer.compare(b[0],a[0]));
        int ans=0;
        for(int i=0;i<k;i++){
            int idx=diff[i][1];
            ans+=arr1[idx];
        }
        for(int i=k;i<n;i++){
            int idx=diff[i][1];
            ans+=arr2[idx];
        }
        return ans;
    }
}
