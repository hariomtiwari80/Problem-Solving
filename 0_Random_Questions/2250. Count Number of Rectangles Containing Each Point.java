class Solution {
    public int[] countRectangles(int[][] r, int[][] p) {
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(r,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<=100;i++) l.add(new ArrayList<>());
        for(int[] a:r){
            l.get(a[1]).add(a[0]);
        }
        int[] ans=new int[p.length];
        int idx=0;
        for(int[] a:p){
            int c=0;
            for(int i=a[1];i<=100;i++){
                if(l.get(i).size()!=0){
                    int id=lower(l.get(i),a[0]);
                    c+=l.get(i).size()-id;
                }
            }
            ans[idx++]=c;
        }
        return ans;
    }
    public int lower(List<Integer> list,int t){
        int l=0,h=list.size();
        while(l<h){
            int m=l+(h-l)/2;
            if(list.get(m)>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
