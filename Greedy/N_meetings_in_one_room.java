class Solution {
    class Pair{
        int s,e;
        Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        Pair[] p=new Pair[start.length];
        for(int i=0;i<start.length;i++){
            p[i]=new Pair(start[i],end[i]);
        }
        Arrays.sort(p,(a,b)->{
            if(a.e==b.e) return a.s-b.s;
            return a.e-b.e;
        });
        int ans=1,curr=p[0].e;
        for(int i=1;i<start.length;i++){
            if(p[i].s>curr){
                ans++;
                curr=p[i].e;
            }
        }
        return ans;
    }
}
