class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<items1.length;i++){
            map1.put(items1[i][0],items1[i][1]);
            set.add(items1[i][0]);
        }
        for(int i=0;i<items2.length;i++){
            int sum=0;
            sum+=items2[i][1];
            if(map1.containsKey(items2[i][0])){
                sum+=map1.get(items2[i][0]);
                set.remove(items2[i][0]);
            }
            List<Integer> l=new ArrayList<>();
            l.add(items2[i][0]);
            l.add(sum);
            ans.add(l);
        }
        for(int i:set){
            List<Integer> l=new ArrayList<>();
            l.add(i);
            l.add(map1.get(i));
            ans.add(l);
        }

        Collections.sort(ans,(a,b)->a.get(0)-b.get(0));
        return ans;

    }
}
