class Solution {
    public int[] par,rank;

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

    public boolean equationsPossible(String[] arr) {
        par=new int[26];
        rank=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(String s:arr){
            if(s.charAt(1)=='='){
                int i=s.charAt(0)-'a';
                int j=s.charAt(3)-'a';
                union(i,j);
            }
        }
        for(String s:arr){
            if(s.charAt(1)=='!'){
                int i=s.charAt(0)-'a';
                int j=s.charAt(3)-'a';
                if(find(i)==find(j)) return false;
            }
        }
        return true;
    }
}
