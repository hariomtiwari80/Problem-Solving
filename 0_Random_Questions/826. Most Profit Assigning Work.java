class Solution {
    public int maxProfitAssignment(int[] diff, int[] pro, int[] work) {
        int n=diff.length,m=work.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=pro[i];
            pair[i][1]=diff[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));
        Arrays.sort(work);
        int j=m-1,i=0;
        int ans=0;
        while(i<n && j>=0){
            int c=0;
            while(j>=0 && work[j]>=pair[i][1]){
                c++;
                j--;
            }
            ans+=(c*pair[i][0]);
            i++;
        }
        return ans;
    }
}
