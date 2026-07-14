class Solution {
    public int[] answerQueries(int[] arr, int[] query) {
        Arrays.sort(arr);
        int[] pre=new int[arr.length];
        pre[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pre[i]=pre[i-1]+arr[i];
        }
        int[] ans=new int[query.length];
        for(int i=0;i<query.length;i++){
            ans[i]=upper(pre,query[i]);
        }
        return ans;
    }
    public int upper(int[] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>t) h=m;
            else l=m+1;
        }
        return l;
    }
}
