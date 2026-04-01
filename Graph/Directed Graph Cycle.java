class Solution {
    public boolean isCyclic(int V, int[][] ed) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<ed.length;i++){
            adj.get(ed[i][0]).add(ed[i][1]);
        }
        boolean[] vis=new boolean[V];
        boolean[] temp=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,i,vis,temp)) return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int n,boolean[] vis,boolean[] temp){
        vis[n]=true;
        temp[n]=true;
        for(int i:adj.get(n)){
            if(!vis[i]){
                if(dfs(adj,i,vis,temp)) return true;
            }
            else{
                if(temp[i]) return true;
            }
        }
        temp[n]=false;
        return false;
    }
}

----------------------------------------------------------------------------------------------------------------

