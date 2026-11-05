class Solution {
    public int[] searchRange(int[] arr, int t) {
        int n=arr.length;
        int l=0,h=n-1,first=-1,last=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==t){
                if(m>0 && arr[m-1]==t) h=m-1;
                else{
                    first=m;
                    break;
                }
            }
            else if(arr[m]<t){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        if(first==-1) return new int[]{-1,-1};
        l=0;
        h=n-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==t){
                if(m+1<n && arr[m+1]==t) l=m+1;
                else{
                    last=m;
                    break;
                }
            }
            else if(arr[m]<t){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return new int[]{first,last};
    }
}