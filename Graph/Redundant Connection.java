class Solution {
    public int[] par;
    public int[] rank;

    public void union(int i,int j){
        int p1=find(i);
        int p2=find(j);
        if(p1==p2) return;
        if(rank[p1]>rank[p2]){
            par[p2]=p1;
        }
        else if(rank[p2]>rank[p1]){
            par[p1]=p2;
        }
        else{
            par[p2]=p1;
            rank[p1]++;
        }
    }

    public int find(int i){
        if(i==par[i]) return i;
        return par[i]=find(par[i]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;    
        }
        
        for(int[] a:edges){
            int p1=find(a[0]-1);
            int p2=find(a[1]-1);
            if(p1==p2) return a;
            union(a[0]-1,a[1]-1);
        }
        return new int[]{-1,-1};
    }
}
