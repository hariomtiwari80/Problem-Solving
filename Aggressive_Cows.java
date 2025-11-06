class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int l=1,h=stalls[n-1]-stalls[0];
        int ans=0;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(stalls,m,k)){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public boolean valid(int[] stalls,int m,int k){
        int c=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=m){
                c++;
                last=stalls[i];
            }
            if(c>=k) return true;
        }
        return false;
    }
}
