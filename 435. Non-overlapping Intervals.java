class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int max=1,end=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]>=end){
                max++;
                end=arr[i][1];
            }
            else{
                end=Math.min(end,arr[i][1]);
            }
        }
        return n-max;
    }
}
