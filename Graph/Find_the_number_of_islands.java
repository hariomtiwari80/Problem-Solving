//Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
class Solution {
    class pair{
        int i,j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int countIslands(char[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='L' && !visited[i][j]){
                    ans++;
                    bfs(arr,visited,i,j);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] arr,boolean[][] visited,int i,int j){
        int n=arr.length,m=arr[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        visited[i][j]=true;
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.i,c=p.j;
            if(r>0 && arr[r-1][c]=='L' && !visited[r-1][c]){
                visited[r-1][c]=true;
                q.add(new pair(r-1,c));
            }
            if(r<n-1 && arr[r+1][c]=='L' && !visited[r+1][c]){
                visited[r+1][c]=true;
                q.add(new pair(r+1,c));
            }
            if(c>0 && arr[r][c-1]=='L' && !visited[r][c-1]){
                visited[r][c-1]=true;
                q.add(new pair(r,c-1));
            }
            if(c<m-1 && arr[r][c+1]=='L' && !visited[r][c+1]){
                visited[r][c+1]=true;
                q.add(new pair(r,c+1));
            }
            if(r>0 && c>0 && arr[r-1][c-1]=='L' && !visited[r-1][c-1]){
                visited[r-1][c-1]=true;
                q.add(new pair(r-1,c-1));
            }
            if(r<n-1 && c<m-1 && arr[r+1][c+1]=='L' && !visited[r+1][c+1]){
                visited[r+1][c+1]=true;
                q.add(new pair(r+1,c+1));
            }
            if(c>0 && r<n-1 &&arr[r+1][c-1]=='L' && !visited[r+1][c-1]){
                visited[r+1][c-1]=true;
                q.add(new pair(r+1,c-1));
            }
            if(r>0 && c<m-1 && arr[r-1][c+1]=='L' && !visited[r-1][c+1]){
                visited[r-1][c+1]=true;
                q.add(new pair(r-1,c+1));
            }
        }
    }
}

--------------------------------------------------------------------------------------

class Solution {
    
    public int countIslands(char[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='L' && !visited[i][j]){
                    ans++;
                    dfs(arr,visited,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] arr,boolean[][] visited,int r,int c){
            int n=arr.length,m=arr[0].length;
            visited[r][c]=true;
            if(r>0 && arr[r-1][c]=='L' && !visited[r-1][c]){
               dfs(arr,visited,r-1,c); 
            }
            if(r<n-1 && arr[r+1][c]=='L' && !visited[r+1][c]){
                dfs(arr,visited,r+1,c);
            }
            if(c>0 && arr[r][c-1]=='L' && !visited[r][c-1]){
                dfs(arr,visited,r,c-1);
            }
            if(c<m-1 && arr[r][c+1]=='L' && !visited[r][c+1]){
                dfs(arr,visited,r,c+1);
            }
            if(r>0 && c>0 && arr[r-1][c-1]=='L' && !visited[r-1][c-1]){
                dfs(arr,visited,r-1,c-1);
            }
            if(r<n-1 && c<m-1 && arr[r+1][c+1]=='L' && !visited[r+1][c+1]){
                dfs(arr,visited,r+1,c+1);
            }
            if(c>0 && r<n-1 &&arr[r+1][c-1]=='L' && !visited[r+1][c-1]){
                dfs(arr,visited,r+1,c-1);
            }
            if(r>0 && c<m-1 && arr[r-1][c+1]=='L' && !visited[r-1][c+1]){
                dfs(arr,visited,r-1,c+1);
            }
    }
}
