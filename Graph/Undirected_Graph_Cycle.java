class Solution {
    public boolean isCycle(int V, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:arr){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,visited,-1,i)) return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int p,int n){
        visited[n]=true;
        for(int i:adj.get(n)){
            if(!visited[i]){
                if(dfs(adj,visited,n,i)) return true;
            }
            else if(i!=p) return true;
        }
        return false;
    }
}

--------------------------------------------------------------------------------------------------

class Solution {
    class pair{
        int p,n;
        pair(int p,int n){
            this.p=p;
            this.n=n;
        }
    }
    public boolean isCycle(int V, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:arr){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(adj,visited,-1,i)) return true;
            }
        }
        return false;
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int c,int n){
        Queue<pair> q=new LinkedList<>();
        visited[n]=true;
        q.add(new pair(c,n));
        while(!q.isEmpty()){
            pair p=q.poll();
            int node=p.n;
            int parent=p.p;
            for(int a:adj.get(node)){
                if(!visited[a]){
                    visited[a]=true;
                    q.add(new pair(node,a));
                }
                else if(a!=parent) return true;
            }
        }
        return false;
    }
}
