class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int a=times[i][0]-1;
            int b=times[i][1]-1;
            int c=times[i][2];
            adj.get(a).add(new int[]{c,b});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k-1]=0;
        pq.add(new int[]{0,k-1});
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            int node=t[1];
            int dis=t[0];
            if(dis>ans[node]) continue;
            for(int[] i:adj.get(node)){
                int node1=i[1];
                int dis1=i[0];
                if(dis+dis1<ans[node1]){
                    ans[node1]=dis+dis1;
                    pq.add(new int[]{ans[node1],node1});
                }

            }
        }
        int min=-1;
        for(int i=0;i<n;i++){
            min=Math.max(min,ans[i]);
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}
