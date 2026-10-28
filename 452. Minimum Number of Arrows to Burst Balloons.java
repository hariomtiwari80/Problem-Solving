class Solution {
    public int findMinArrowShots(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        int cnt=1,end=arr[0][1];
        for(int i=1;i<n;i++){
            if(end>=arr[i][0]){
                end=Math.min(end,arr[i][1]);
            }
            else{
                cnt++;
                end=arr[i][1];
            }
        }
        return cnt;
    }
}
