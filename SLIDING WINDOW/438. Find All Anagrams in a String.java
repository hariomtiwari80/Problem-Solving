class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int[] sf=new int[26];
        int[] pf=new int[26];
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            pf[ch-'a']++;
        }
        int i=0,j=0,cnt=0;
        while(j<s.length()){
            char c=s.charAt(j);
            sf[c-'a']++;
            while(j-i+1>p.length()){
                sf[s.charAt(i)-'a']--;
                i++;
            }
            if(isSame(sf,pf)) ans.add(i);
            j++;
        }
        return ans;
    }
    public boolean isSame(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
