class Solution {
    public int searchInsert(int[] arr, int t) {
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
