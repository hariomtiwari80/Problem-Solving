class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n=arr.length;
        if(n<=1) return 0;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int pre=arr[0][1],c=0;
        for(int i=1;i<n;i++){
            if(arr[i][0]>=pre){
                pre=arr[i][1];
            }
            else{
                c++;
                pre=Math.min(pre,arr[i][1]);
            }
        }
        return c;
    }
}
