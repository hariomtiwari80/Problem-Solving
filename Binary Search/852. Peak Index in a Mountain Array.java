class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,h=arr.length-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]==arr[m+1]){
                int left=m-1,right=m+1;
                while(left>=l && arr[left]==arr[m]) left--;
                while(right<=h && arr[right]==arr[m]) right++;
                if(arr[left]>arr[right] && arr[left]>arr[m]) h=left;
                else l=right;
            }
            else if(arr[m]>arr[m+1]){
                h=m;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }
}
