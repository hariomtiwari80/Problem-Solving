class Solution {
    class pair{
        int n,p;
        pair(int n,int p){
            this.n=n;
            this.p=p;
        }
    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,bfs(adj,i,n));
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    public int bfs(List<List<Integer>> adj,int n,int m){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(n,-1));
        int[] dis=new int[m];
        Arrays.fill(dis,-1);
        dis[n]=0;
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            pair t=q.poll();
            int node=t.n;
            int par=t.p;
            for(int i:adj.get(node)){
                if(dis[i]==-1){
                    q.add(new pair(i,node));
                    dis[i]=dis[node]+1;
                }
                else{
                    if(i!=par){
                        min=Math.min(min,dis[i]+dis[node]+1);
                    }
                }
            }
        }
        return min;
    }
}

------------------------------------------------------------------------

class Solution {
    public int ans=Integer.MIN_VALUE;
    public int longestCycle(int[] arr) {
        int n=arr.length;
        boolean[] vis=new boolean[n];
        boolean[] rec=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                HashMap<Integer,Integer> map=new HashMap<>();
                map.put(i,0);
                dfs(arr,vis,rec,i,map);
            }
        }
        if(ans==Integer.MIN_VALUE) return -1;
        return ans;
    }
    public void dfs(int[] arr,boolean[] vis,boolean[] rec,int n,HashMap<Integer,Integer> map){
        vis[n]=true;
        rec[n]=true;
        if(arr[n]!=-1){
            if(!vis[arr[n]]){
                map.put(arr[n],map.get(n)+1);
                dfs(arr,vis,rec,arr[n],map);
            }
            else if(rec[arr[n]]){
                ans=Math.max(ans,map.get(n)-map.get(arr[n])+1);
            }
        }
        rec[n]=false;
    }
}
