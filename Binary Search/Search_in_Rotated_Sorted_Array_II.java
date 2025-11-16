class Solution {
    public boolean search(int[] arr, int t) {
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==t) return true;
            if(arr[l]==arr[m] && arr[m]==arr[h]){
                l++;
                h--;
                continue;
            }
            else if(arr[l]<=arr[m]){
                if(t>=arr[l] && t<arr[m]) h=m-1;
                else l=m+1;
            }
            else{
                if(t<=arr[h] && t>arr[m]){
                    l=m+1;
                }
                else h=m-1;
            }
        }
        return false;
    }
}
