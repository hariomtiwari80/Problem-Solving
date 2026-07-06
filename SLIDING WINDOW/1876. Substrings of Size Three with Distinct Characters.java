class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        if(n<3) return 0;
        int i=0,j=1,k=2,c=0;
        while(k<n){
            if(s.charAt(i)!=s.charAt(j) && s.charAt(j)!=s.charAt(k) && s.charAt(k)!=s.charAt(i)) c++;
            i++;
            j++;
            k++;
        }
        return c;
    }
}
