class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int gain=0,start=0;
        int sg=0,sc=0;
        for(int i=0;i<n;i++){
            sg+=gas[i];
            sc+=cost[i];
            gain+=gas[i];
            if(cost[i]>gain){
                start=i+1;
                gain=0;
            }
            else gain-=cost[i];
        }
        if(start==n || sc>sg) return -1;
        return start;
    }
}
