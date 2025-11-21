class Solution {
    public int maxProfitAssignment(int[] diff, int[] pro, int[] w) {
        int ans=0;
        for(int x:w){
            ans+=find(diff,pro,x);
        }
        return ans;
    }
    public int find(int[] diff,int[] pro,int x){
        int max=0;
        for(int i=0;i<diff.length;i++){
            if(diff[i]<=x){
                max=Math.max(max,pro[i]);
            }
        }
        return max;
    }
}

-----------------------------------------------------------------------------------

