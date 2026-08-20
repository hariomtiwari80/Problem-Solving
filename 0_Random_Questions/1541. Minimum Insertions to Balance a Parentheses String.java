class Solution {
    public int minInsertions(String s) {
        int open=0,ans=0;
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open==0) ans++;
                    else open--;
                    i++;
                }
                else{
                    if(open==0) ans+=2;
                    else{
                        ans++;
                        open--;
                    }
                }
            }
            i++;
        }
        return ans+2*open;
    }
}
