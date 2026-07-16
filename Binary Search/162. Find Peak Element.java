class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int l=0,h=n-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(m+1<n && arr[m]<arr[m+1]) l=m+1;
            else h=m;
        }
        return l;
    }
}
