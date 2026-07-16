class Solution {
    public int arrangeCoins(int n) {
        int l=0,h=n;
        while(l<h){
            int m=l+(h-l)/2;
            long t=(long)(m+1)*(m+2)/2;
            if(t>n) h=m;
            else l=m+1;
        }
        return l;
    }
}
