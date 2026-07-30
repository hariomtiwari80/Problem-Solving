class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        List<Integer> l=new ArrayList<>();
        l.add(arr[0]);
        for(int i=1;i<n;i++){
            int idx=higher(l,arr[i]);
            if(idx==l.size()) l.add(arr[i]);
            else l.set(idx,arr[i]);
            ans[i]=idx+1;
        }
        return ans;
    }
    public int higher(List<Integer> li,int t){
        int l=0,h=li.size();
        while(l<h){
            int m=l+(h-l)/2;
            if(li.get(m)>t) h=m;
            else l=m+1;
        }
        return l;
    }
}
