class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr) map.put(i,map.getOrDefault(i,0)+1);
        for(int key:map.keySet()){
            if(map.get(key)>1) ans.add(key);
        }
        return ans;
    }
}
