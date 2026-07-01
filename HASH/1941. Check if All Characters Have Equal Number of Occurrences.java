class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        HashSet<Integer> set=new HashSet<>();
        for(char k:map.keySet()){
            set.add(map.get(k));
        }
        return set.size()==1;
    }
}
