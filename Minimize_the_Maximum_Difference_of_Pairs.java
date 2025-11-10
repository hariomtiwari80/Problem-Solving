class Solution {
    public int minimizeMax(int[] arr, int p) {
        if(p==0 || arr.length==0) return 0;
        Arrays.sort(arr);
        int l=Integer.MAX_VALUE,h=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            l=Math.min(l,arr[i]-arr[i-1]);
            h=Math.max(h,arr[i]-arr[i-1]);
        }
        int ans=h;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(arr,m,p)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,int m,int p){
        int c=0,i=1;
        while(i<arr.length){
            if(arr[i]-arr[i-1]<=m){
                c++;
                i++;
            }
            i++;
        }
        return c>=p;
    }
}
