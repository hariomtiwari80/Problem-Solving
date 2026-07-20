class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
       int l=1,h=x;
       while(l<h){
        int m=l+(h-l)/2;
        if(m==(x/m)) return m;
        else if(m>(x/m)) h=m;
        else l=m+1;
       } 
       return l-1;
    }
}
