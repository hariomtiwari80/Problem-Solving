class Solution {
    public int[] shortestPath(int n, int[][] edges, int src) {
        int m=edges.length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(new int[]{1,b});
            adj.get(b).add(new int[]{1,a});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        pq.add(new int[]{0,src});
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
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}
