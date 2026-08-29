class Solution {
    public int maxHeight(int[][] arr) {
        int n=arr.length;
        for(int[] a:arr) Arrays.sort(a);
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]) return Integer.compare(a[2],b[2]);
                else return Integer.compare(a[1],b[1]);
            }
            else return Integer.compare(a[0],b[0]);
        });
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=arr[i][2];
        int max=dp[0];
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i][0]>=arr[j][0] && arr[i][1]>=arr[j][1] && arr[i][2]>=arr[j][2]){
                    dp[i]=Math.max(dp[i],arr[i][2]+dp[j]);
                }
            }
            System.out.print(dp[i]+" ");
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
