class Solution {
    public int minimumSeconds(List<Integer> l) {
        int n=l.size();
        if(n==1 || same(l)) return 0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(l.get(i))){
                map.get(l.get(i)).add(i);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                map.put(l.get(i),temp);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(List<Integer> list:map.values()){
            int max=0;
            for(int i=1;i<list.size();i++){
                max=Math.max(max,list.get(i)-list.get(i-1));
            }
            max=Math.max(max,n-list.get(list.size()-1)+list.get(0));
            ans=Math.min(ans,max/2);
        }
        return ans;

    }
    public boolean same(List<Integer> l){
        for(int i=1;i<l.size();i++){
            if(l.get(i)!=l.get(i-1)) return false;
        }
        return true;
    }
}
