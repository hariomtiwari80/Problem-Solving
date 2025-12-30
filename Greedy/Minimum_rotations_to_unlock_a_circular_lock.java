
class Solution {
    static int rotationCount(long R, long D) {
        int ans=0;
        while(R!=0){
            long r1=R%10;
            long r2=D%10;
            if(r1<r2) ans+=Math.min(r2-r1,10-r2+r1);
            else ans+=Math.min(r1-r2,10-r1+r2);
            R/=10;
            D/=10;
        }
        return ans;
    }
}
