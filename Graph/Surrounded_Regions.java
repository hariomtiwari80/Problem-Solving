class Solution {
    public int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] arr) {
        int n=arr.length,m=arr[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(!visited[i][0] && arr[i][0]=='O'){
                dfs(arr,visited,i,0);
            }
            if(!visited[i][m-1] && arr[i][m-1]=='O'){
                dfs(arr,visited,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(!visited[0][i] && arr[0][i]=='O'){
                dfs(arr,visited,0,i);
            }
            if(!visited[n-1][i] && arr[n-1][i]=='O'){
                dfs(arr,visited,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='O' && !visited[i][j]) arr[i][j]='X';
            }
        }
    }
    public void dfs(char[][] arr,boolean[][] visited,int i,int j){
        int n=arr.length,m=arr[0].length;
        visited[i][j]=true;
        for(int[] a:dir){
            int r=i+a[0];
            int c=j+a[1];
            if(r>=0 && c>=0 && r<n && c<m && arr[r][c]=='O' && !visited[r][c]){
                dfs(arr,visited,r,c);
            }
        }
    }
}
