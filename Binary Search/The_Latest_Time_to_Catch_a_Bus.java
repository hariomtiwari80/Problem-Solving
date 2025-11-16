class Solution {
    public int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        Arrays.sort(b);
        Arrays.sort(p);
        HashSet<Integer> set=new HashSet<>();
        for(int x:p){
            set.add(x);
        }
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<p.length;i++){
            if(!set.contains(p[i]-1) && p[i]!=1) li.add(p[i]-1);
            if(!set.contains(p[i]+1) && p[i]<b[b.length-1]) li.add(p[i]+1);
        }
        for (int bus:b) {
            if (!set.contains(bus)) li.add(bus);
        }
        Collections.sort(li);
        int l=0,h=li.size()-1;
        int ans=1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(valid(b,p,li.get(m),c)){
                ans=li.get(m);
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public boolean valid(int[] b,int[] p,int m,int c){
        List<Integer> t=new ArrayList<>();
        for(int i=0;i<p.length;i++){
            t.add(p[i]);
        }
        t.add(m);
        Collections.sort(t);
        int j=0;
        for(int i=0;i<b.length;i++){
            int cp=c;
            while(j<t.size() && cp>0 && t.get(j)<=b[i]){
                if(t.get(j)==m) return true;
                j++;
                cp--;
            }
        }
        return false;
    } 
}
