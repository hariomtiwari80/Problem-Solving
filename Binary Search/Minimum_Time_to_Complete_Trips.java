class Solution {
    public long minimumTime(int[] time, int totalTrips) {

        long l=1,h=0;
        for(int x:time){
            h=Math.max(h,x);
        }
        h*=totalTrips;
        long ans=0;
        while(l<=h){
            long m=l+(h-l)/2;
            if(valid(time,m,(long)totalTrips)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] time,long m,long totalTrips){
        long c=0;
        for(int x:time){
            c+=m/x;
        }
        return c>=totalTrips;
    }
}
