class Solution {
    class pair{
        int id,e,d;
        pair(int id,int e,int d){
            this.id=id;
            this.e=e;
            this.d=d;
        }
    }
    public int[] getOrder(int[][] arr) {
        int n=arr.length;
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            p[i]=new pair(i,arr[i][0],arr[i][1]);
        }
        Arrays.sort(p,(a,b)->{
            if(a.d==b.d) return a.id-b.id;
            return a.d-b.d;
        });
        boolean[] b=new boolean[n];
        int remain=n;
        int k=0;
        ArrayList<Integer> ans =new ArrayList<>();
        while(remain!=0){
            for(int i=0;i<n;i++){
                if(b[p[i].id]==false && p[i].e<=k){
                    ans.add(p[i].id);
                    b[p[i].id]=true;
                    k+=(p[i].d-1);
                    remain--;
                    break;
                }
            }
            k++;
        }
        int[] t=new int[n];
        for(int i=0;i<n;i++){
            t[i]=ans.get(i);
        }
        return t;
    }
}

---------------------------------------------------------------------

class Solution {
    class pair{
        int id,e,d;
        pair(int id,int e,int d){
            this.id=id;
            this.e=e;
            this.d=d;
        }
    }
    public int[] getOrder(int[][] arr) {
        int n=arr.length;
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            p[i]=new pair(i,arr[i][0],arr[i][1]);
        }
        Arrays.sort(p,(a,b)->{
            if(a.e==b.e) return a.id-b.id;
            return a.e-b.e;
        });
        PriorityQueue<pair> pq=new PriorityQueue<>(
            (a,b)->{
            if(a.d==b.d) return a.id-b.id;
            return a.d-b.d;
            }
        );
        int[] ans=new int[n];
        int i=0,k=0,r=0;
        while(r<n){
            while(i<n && p[i].e<=k){
                pq.offer(p[i]);
                i++;
            }
            if(pq.isEmpty()){
                k=p[i].e;
                continue;
            }
            pair curr=pq.poll();
            ans[r++]=curr.id;
            k+=curr.d;
        }   
        return ans;
    }
}
