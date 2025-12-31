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

-------------------------------------------------------------------------------------

class Solution {
    class Pair{
        int de,pr;
        Pair(int de,int pr){
            this.de=de;
            this.pr=pr;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] dead, int[] pro) {
        ArrayList<Integer> ans=new ArrayList<>();
        int profit=0,job=0,n=dead.length;
        Pair[] p=new Pair[n];
        int max=0;
        for(int i=0;i<n;i++){
            p[i]=new Pair(dead[i],pro[i]);
            max=Math.max(max,dead[i]);
        }
        Arrays.sort(p,(a,b)->{
           return b.pr-a.pr; 
        });
        
        int[] arr=new int[max+1];
        for(int i=0;i<=max;i++){
            arr[i]=i;
        }
        for(int i=0;i<n;i++){
            int id=solve(p[i].de,arr);
            if(id!=0){
                arr[id]=solve(id-1,arr);
                profit+=p[i].pr;
                job++;
            }
        }
        ans.add(job);
        ans.add(profit);
        return ans;
    }
    public int solve(int i,int[] arr){
        if(arr[i]==i) return i;
        return arr[i]=solve(arr[i],arr);
    }
}
