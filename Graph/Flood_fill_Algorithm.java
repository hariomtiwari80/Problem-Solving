class Solution {
    class pair{
        int i,j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length,m=image[0].length;
        int[][] ans=new int[n][m];
        for(int[] a:ans) Arrays.fill(a,-1);
        bfs(image,color,ans,sr,sc);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]==-1) ans[i][j]=image[i][j];
            }
        }
        return ans;
    }
    public void bfs(int[][] arr,int ci,int[][] ans,int i,int j){
        int n=arr.length,m=arr[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        ans[i][j]=ci;
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.i;
            int c=p.j;
            if(r>0 && arr[r][c]==arr[r-1][c] && ans[r-1][c]==-1){
                ans[r-1][c]=ci;
                q.add(new pair(r-1,c));
            }
            if(r<n-1 && arr[r][c]==arr[r+1][c] && ans[r+1][c]==-1){
                ans[r+1][c]=ci;
                q.add(new pair(r+1,c));
            }
            if(c>0 && arr[r][c]==arr[r][c-1] && ans[r][c-1]==-1){
                ans[r][c-1]=ci;
                q.add(new pair(r,c-1));
            }
            if(c<m-1 && arr[r][c]==arr[r][c+1] && ans[r][c+1]==-1){
                ans[r][c+1]=ci;
                q.add(new pair(r,c+1));
            }
        }
    }
}

---------------------------------------------------------------------------

class Solution {
    public int[][] floodFill(int[][] arr, int r, int c, int ci) {
        int n=arr.length,m=arr[0].length;
        int[][] ans=new int[n][m];
        if(arr[r][c]==ci) return arr;
        for(int[] a:ans){
            Arrays.fill(a,-1);
        }
        dfs(arr,ans,r,c,ci,arr[r][c]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]==-1) ans[i][j]=arr[i][j];
            }
        }
        return ans;
    }
    public void dfs(int[][] arr,int[][] ans,int r,int c,int ci,int s){
        int n=arr.length,m=arr[0].length;
        ans[r][c]=ci;
        if(r>0 && ans[r-1][c]==-1 && arr[r-1][c]==s){
            dfs(arr,ans,r-1,c,ci,s);
        }
        if(r<n-1 && ans[r+1][c]==-1 && arr[r+1][c]==s){
            dfs(arr,ans,r+1,c,ci,s);
        }
        if(c>0 && ans[r][c-1]==-1 && arr[r][c-1]==s){
            dfs(arr,ans,r,c-1,ci,s);
        }
        if(c<m-1 && ans[r][c+1]==-1 && arr[r][c+1]==s){
            dfs(arr,ans,r,c+1,ci,s);
        }
    }
}
