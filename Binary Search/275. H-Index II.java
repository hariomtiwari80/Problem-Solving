class Solution {
    public int hIndex(int[] arr) {
        int max=0;
        for(int i=1;i<=arr.length;i++){
            int lb=lower(arr,i);
            if(arr.length-lb>=i){
                max=Math.max(max,i);
            }
        }
        return max;
    }
    public int lower(int[] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return h;
    }
}
