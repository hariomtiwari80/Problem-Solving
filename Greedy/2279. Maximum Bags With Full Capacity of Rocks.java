class Solution {
    public int maximumBags(int[] cap, int[] rock, int add) {
        int n=cap.length;
        int c=0;
        int[] req=new int[n];
        for(int i=0;i<n;i++){
            req[i]=cap[i]-rock[i];
        }
        Arrays.sort(req);
        for(int i=0;i<n;i++){
            if(req[i]==0){
                c++;
                continue;
            }
            if(req[i]<=add){
                add-=req[i];
                c++;
            }
        }
        return c;
    }
}
