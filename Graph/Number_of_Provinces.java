class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        if(n<=1) return n;
        boolean[] visited=new boolean[n];
        int prov=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                prov++;
                bfs(adj,visited,i);
            }
        }
        return prov;
    }
    public void bfs(int[][] adj,boolean[] visited,int v){
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        visited[v]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[temp][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}

---------------------------------------------------------------

class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        if(n<=1) return n;
        boolean[] visited=new boolean[n];
        int prov=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                prov++;
                dfs(adj,visited,i);
            }
        }
        return prov;
    }
    public void dfs(int[][] adj,boolean[] visited,int v){
        visited[v]=true;
        for(int i=0;i<adj.length;i++){
            if(adj[v][i]==1 && !visited[i]) dfs(adj,visited,i);
        }
    }
}
