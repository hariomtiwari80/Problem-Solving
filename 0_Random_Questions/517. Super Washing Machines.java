class Solution {
    public int findMinMoves(int[] mac) {
        int n=mac.length;
        int sum=0;
        for(int x:mac) sum+=x;
        if(sum%n!=0) return -1;
        int req=sum/n;
        int ans=Integer.MIN_VALUE,pre=0;
        for(int x:mac){
            int sub=x-req;
            pre+=sub;
            ans=Math.max(ans,Math.max(sub,Math.abs(pre)));
        }
        return ans;
    }
}
