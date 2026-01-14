class Solution {
    class pair{
        int i,j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] visited=new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    max=Math.max(max,bfs(arr,visited,i,j));
                }
            }
        }
        return max;
    }
    public int bfs(int[][] arr,boolean[][] visited,int i,int j){
        int n=arr.length,m=arr[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        visited[i][j]=true;
        int co=1;
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int[] a:dir){
                int r=p.i+a[0] ,c=p.j+a[1];
                if(r>=0 && c>=0 && r<n && c<m && !visited[r][c] && arr[r][c]==1){
                    q.add(new pair(r,c));
                    visited[r][c]=true;
                    co++;
                }
            }
        }
        return co;
    }
}

---------------------------------------------------------------------------------------------------

class Solution {
    public int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] visited=new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    max=Math.max(max,dfs(arr,visited,i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] arr,boolean[][] visited,int i,int j){
        int n=arr.length,m=arr[0].length;
        int co=1;
        visited[i][j]=true;
        for(int[] a:dir){
            int r=i+a[0] ,c=j+a[1];
            if(r>=0 && c>=0 && r<n && c<m && !visited[r][c] && arr[r][c]==1){
                co+=dfs(arr,visited,r,c);
            }
        }
        return co;
    }
}
