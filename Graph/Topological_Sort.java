class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean[] visited=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
        }
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,visited,i,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int i,Stack<Integer> st){
        visited[i]=true;
        for(int n:adj.get(i)){
            if(!visited[n]) dfs(adj,visited,n,st);
        }
        st.add(i);
    }
}
