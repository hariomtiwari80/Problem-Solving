class Solution {
    public char nextGreatestLetter(char[] arr, char t) {
        int n=arr.length;
        int l=0,h=n;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>t) h=m;
            else l=m+1;
        }
        if(l==n) return arr[0];
        else return arr[l];
    }
}
