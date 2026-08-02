class Solution {
    public long repairCars(int[] arr, int car) {
        long max=Integer.MIN_VALUE;
        for(int x:arr){
            max=Math.max(max,x);
        }
        long l=1,h=max*car*car;
        long ans=0;
        while(l<=h){
            long m=l+(h-l)/2;
            if(valid(arr,m,car)){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean valid(int[] arr,long m,int car){
        long c=0;
        for(int x:arr){
            c+=Math.sqrt(m/x);
            if(c>=car) return true;
        }
        return c>=car;
    }
}
