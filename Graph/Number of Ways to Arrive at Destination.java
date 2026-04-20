class Solution {
    class pair{
        long d;
        int n;
        pair(long d,int n){
            this.d=d;
            this.n=n;
        }
    }
    public int countPaths(int m, int[][] arr) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<m;i++) adj.add(new ArrayList<>());
        for(int[] a:arr){
            adj.get(a[0]).add(new int[]{a[1],a[2]});
            adj.get(a[1]).add(new int[]{a[0],a[2]});
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.d, b.d));
        long[] dis=new long[m];
        int[] vis=new int[m];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        vis[0]=1;
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            long d=p.d;
            int n=p.n;
            if (d>dis[n]) continue;
            for(int[] i:adj.get(n)){
                long d1=i[1];
                int n1=i[0];
                if(d+d1<dis[n1]){
                    dis[n1]=d+d1;
                    vis[n1]=vis[n];
                    pq.add(new pair(d+d1,n1));
                }
                else if(d1+d==dis[n1]){
                    vis[n1]=(vis[n1]+vis[n])%1000000007;
                }
            }
        }
        return vis[m-1];
    }
}
