class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int ans=0;
        int i=0,j=0;
        while(j<n){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            ans=Math.max(ans,j-i+1);
            j++; 
        }
        return ans;
    }
}
