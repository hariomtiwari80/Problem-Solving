class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,i);
        }
        int c=0;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            c+=Math.abs(map.get(ch)-i);
        }
        return c;
    }
}
