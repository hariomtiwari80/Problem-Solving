class Solution {
    public ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        int n=edges.length;
        int[][] adj=new int[V][V];
        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj[a][b]=1;
            adj[b][a]=1;
        }
        ans=new ArrayList<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
               bfs(adj,visited,i,V); 
            }
        }
        return ans;
    }

    public void bfs(int[][] adj,boolean[] visited,int j,int v){
        Queue<Integer> q=new LinkedList<>();
        visited[j]=true;
        q.add(j);
        ArrayList<Integer> l=new ArrayList<>();
        l.add(j);
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i=0;i<v;i++){
                if(adj[t][i]==1 && !visited[i]){
                    l.add(i);
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        Collections.sort(l);
        ans.add(l);
    }
}

--------------------------------------------------------------------------------

class Solution {
    public ArrayList<ArrayList<Integer>> ans;

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        int n = edges.length;
        int[][] adj = new int[V][V];
        for(int i = 0; i < n; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(adj, visited, i, V, comp);
                Collections.sort(comp);
                ans.add(comp);
            }
        }
        return ans;
    }

    public void dfs(int[][] adj, boolean[] visited, int node, int V, ArrayList<Integer> comp){
        visited[node] = true;
        comp.add(node);

        for(int i = 0; i < V; i++){
            if(adj[node][i] == 1 && !visited[i]){
                dfs(adj, visited, i, V, comp);
            }
        }
    }
}
