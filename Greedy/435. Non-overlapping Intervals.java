class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n=arr.length;
        if(n==1) return 0;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int c=0;
        int i=0,j=1;
        while(j<n){
            if(arr[j][0]<arr[i][1]){
                c++;
                if(arr[j][1]<arr[i][1]){
                    i=j;
                }
            }
            else i=j;
            j++;
        }
        return c;
    }
}
