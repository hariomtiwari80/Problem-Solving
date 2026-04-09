class Solution {
    public int[] parent;
    public int[] rank;
    
    public void union(int i,int j){
        int p1=find(i);
        int p2=find(j);
        if(p1==p2) return;
        if(rank[p1]>rank[p2]){
            parent[p2]=p1;
        }
        else if(rank[p2]>rank[p1]){
            parent[p1]=p2;
        }
        else{
            parent[j]=p1;
            rank[p1]++;
        }
    }
    
    public int find(int i){
        if(i==parent[i]) return i;
        return parent[i]=find(parent[i]);
    }
    
    public boolean isCycle(int V, int[][] ed) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        parent=new int[V];
        rank=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<ed.length;i++){
            adj.get(ed[i][0]).add(ed[i][1]);
            adj.get(ed[i][1]).add(ed[i][0]);
        }
        
        for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
                if(i<j){
                    int p1=find(i);
                    int p2=find(j);
                    if(p1==p2) return true;
                    union(i,j);
                }
            }
        }
        return false;
        
    }
}
