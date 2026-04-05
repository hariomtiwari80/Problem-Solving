class Solution {
    int[] ans;
    public int[] gardenNoAdj(int n, int[][] path) {
        ans=new int[n];
        Arrays.fill(ans,-1);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<path.length;i++){
            adj.get(path[i][0]-1).add(path[i][1]-1);
            adj.get(path[i][1]-1).add(path[i][0]-1);
        }
        for(int i=0;i<n;i++){
            boolean[] b=new boolean[5];
            for(int j:adj.get(i)){
                if(ans[j]!=-1) b[ans[j]]=true;
            }
            for(int j=1;j<=4;j++){
                if(!b[j]){
                    ans[i]=j;
                    break;
                }
            }
        }
        return ans;
    }
}
