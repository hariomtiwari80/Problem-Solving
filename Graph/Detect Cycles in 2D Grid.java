class Solution {
    class pair{
        int r,c,pr,pc;
        pair(int r,int c,int pr,int pc){
            this.r=r;
            this.c=c;
            this.pr=pr;
            this.pc=pc;
        }
    }
    public int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public boolean containsCycle(char[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(cycle(arr,i,j,vis)) return true;
                }
            }
        }
        return false;
    }
    public boolean cycle(char[][] arr,int i,int j,boolean[][] vis){
        int n=arr.length,m=arr[0].length;
        vis[i][j]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j,-1,-1));
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.r,c=p.c,pr=p.pr,pc=p.pc;
            for(int[] a:dir){
                int nr=r+a[0];
                int nc=c+a[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && arr[nr][nc]==arr[r][c]){
                    if(!vis[nr][nc]){
                        vis[nr][nc]=true;
                        q.add(new pair(nr,nc,r,c));
                    }
                    else{
                        if(nr!=pr || nc!=pc) return true;
                    }
                }
            }
        }
        return false;
    }
}
