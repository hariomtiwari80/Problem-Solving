class Solution {
    public String sortVowels(String s) {
        List<Character> l=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))) l.add(s.charAt(i));
        }
        Collections.sort(l);
        int idx=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isVowel(ch)){
                ans.append(l.get(idx++));
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    public boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') return true;
        return false;
    }
}
