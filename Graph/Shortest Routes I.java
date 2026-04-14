import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int c=sc.nextInt();
            adj.get(a).add(new int[]{c,b});
            adj.get(b).add(new int[]{c,a});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            int node=t[1];
            int dis=t[0];
            for(int[] i:adj.get(node)){
                int node1=i[1];
                int dis1=i[0];
                if(dis+dis1<ans[node1]){
                    ans[node1]=dis+dis1;
                    pq.add(new int[]{ans[node1],node1});
                }

            }
        }
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}

-----------------------------------------------------------------------

import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int c=sc.nextInt();
            adj.get(a).add(new int[]{c,b});
            adj.get(b).add(new int[]{c,a});
        }
        TreeSet<int[]> set=new TreeSet<> ((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        set.add(new int[]{0,0});
        while(!set.isEmpty()){
            int[] t=set.pollFirst();
            int node=t[1];
            int dis=t[0];
            for(int[] i:adj.get(node)){
                int node1=i[1];
                int dis1=i[0];
                if(dis+dis1<ans[node1]){
                    if(ans[node1]!=Integer.MAX_VALUE){
                        set.remove(new int[]{ans[node1],node1});
                    }
                    ans[node1]=dis+dis1;
                    set.add(new int[]{ans[node1],node1});
                }

            }
        }
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}
