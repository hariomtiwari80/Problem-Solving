class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length(),max=Integer.MIN_VALUE,c=0;
        int l=0,r=0;
        while(r<n){
            char ch=s.charAt(r);
            if(isVowel(ch)) c++;
            if(r-l+1==k){
                max=Math.max(max,c);
                if(isVowel(s.charAt(l))){
                    c--;
                }
                l++;
            }
            r++;
        }
        return max;
    }
    public boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        else return false;
    }
}
