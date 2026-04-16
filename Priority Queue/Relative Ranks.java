class Solution {
    class pair{
        int sc,id;
        pair(int sc,int id){
            this.sc=sc;
            this.id=id;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.sc - a.sc);
        for(int i=0;i<score.length;i++){
            pq.add(new pair(score[i],i));
        }
        String[] ans=new String[score.length];
        int c=1;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int idx=p.id;
            if(c==1){
                ans[idx]="Gold Medal";
            }
            else if(c==2){
                ans[idx]="Silver Medal";
            }
            else if(c==3){
                ans[idx]="Bronze Medal";
            }
            else{
                String s=""+c;
                ans[idx]=s;
            }
            c++;
        }
        return ans;
    }
}
