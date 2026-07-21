class Solution {
    public int findKRotation(int arr[]) {
        int n=arr.length;
        if(arr[n-1]>arr[0]) return 0;
        int l=0,h=n-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>arr[h]) l=m+1;
            else h=m;
        }
        return l;
    }
}
