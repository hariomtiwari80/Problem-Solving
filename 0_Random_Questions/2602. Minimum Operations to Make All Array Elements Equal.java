class Solution {
    public List<Long> minOperations(int[] arr, int[] queries) {
        int n=arr.length;
        Arrays.sort(arr);
        List<Long> ans=new ArrayList<>();
        long[] pre=new long[n];
        pre[0]=(long)arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(long)arr[i];
        }
        for(int x:queries){
            int idx=lowerBound(arr,x);
            long left=0,right=0;
            if(idx!=0){
                left=(long)x*idx-pre[idx-1];
            }
            if(idx==0) right=pre[n-1]-(long)x*(n-idx);
            else right=pre[n-1]-pre[idx-1]-(long)x*(n-idx);
            ans.add(left+right);
        }
        return ans;
    }
    public int lowerBound(int[] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
