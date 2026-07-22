class RangeFreqQuery {
    public HashMap<Integer,List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> l=map.get(value);
        if(l==null) return 0;
        int idx1=lower(l,left);
        int idx2=lower(l,right+1);
        return idx2-idx1;
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

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
