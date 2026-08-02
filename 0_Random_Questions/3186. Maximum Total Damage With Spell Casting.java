class Solution {
    public long maximumTotalDamage(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:arr) map.put(x,map.getOrDefault(x,0)+1);
        List<Integer> l=new ArrayList<>(map.keySet());
        Collections.sort(l);
        long[] freq=new long[l.size()];
        freq[0]=1L*l.get(0)*map.get(l.get(0));
        for(int i=1;i<l.size();i++){
            long total=1L*l.get(i)*map.get(l.get(i));
            int idx=binarySearch(l,l.get(i)-3,i);
            if(idx!=-1) total+=freq[idx];
            freq[i]=Math.max(freq[i-1],total);
        }
        return freq[l.size()-1];
    }
    public int binarySearch(List<Integer> li,int t,int idx){
        int l=0,h=idx-1;
        int ans=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(li.get(m)<=t){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
}
