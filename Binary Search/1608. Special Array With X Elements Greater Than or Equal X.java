class Solution {
    public int specialArray(int[] arr) {
        Arrays.sort(arr);
        for(int i=1;i<=arr.length;i++){
            int lb=lower(arr,i);
            if(arr.length-lb==i) return i;
        }
        return -1;
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
