class Solution {
    public int[] getAverages(int[] arr, int k) {
        int[] ans=new int[arr.length];
        Arrays.fill(ans,-1);
        if(arr.length<2*k+1) return ans;
        long sum=0;
        for(int i=0;i<=2*k;i++){
            sum+=arr[i];
        }
        int idx=k;
        ans[idx++]=(int)(sum/(2*k+1));
        int i=0,j=2*k+1;
        while(j<arr.length){
            sum+=arr[j++];
            sum-=arr[i++];
            ans[idx++]=(int)(sum/(2*k+1));
        }
        return ans;
    }
}
