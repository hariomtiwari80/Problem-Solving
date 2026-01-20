class Solution {
    class pair{
        int i,j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] v1=new boolean[n][m];
        boolean[][] v2=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(!v1[i][0]){
                bfs(arr,v1,i,0);
            }
            if(!v2[i][m-1]){
                bfs(arr,v2,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(!v1[0][i]){
                bfs(arr,v1,0,i);
            }
            if(!v2[n-1][i]){
                bfs(arr,v2,n-1,i);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(v1[i][j] && v2[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] arr,boolean[][] visited,int i,int j){
        int n=arr.length,m=arr[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        visited[i][j]=true;
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int[] a:dir){
                int r=a[0]+p.i,c=a[1]+p.j;
                if(r>=0 && r<n && c>=0 && c<m && arr[p.i][p.j]<=arr[r][c] && !visited[r][c]){
                    q.add(new pair(r,c));
                    visited[r][c]=true;
                }
            }
        }
    }
}
