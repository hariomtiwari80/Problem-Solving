class Solution {
    class Pair{
        int d,p;
        Pair(int d,int p){
            this.d=d;
            this.p=p;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] dead, int[] pro) {
        ArrayList<Integer> ans=new ArrayList<>();
        Pair[] pi=new Pair[dead.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dead.length;i++){
            pi[i]=new Pair(dead[i],pro[i]);
            max=Math.max(max,dead[i]);
        }
        Arrays.sort(pi,(a,b)->a.p-b.p);
        int[] b=new int[max+1];
        int profit=0,job=0;
        for(int i=dead.length-1;i>=0;i--){
            for(int j=pi[i].d;j>0;j--){
                if(b[j]==0){
                    b[j]=1;
                    profit+=pi[i].p;
                    job++;
                    break;
                }
            }
        }
        ans.add(job);
        ans.add(profit);
        return ans;
    }
}
