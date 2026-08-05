class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        if(n<4) return "";
        String ans="";
        Stack<Character> st=new Stack<>();
        st.push('(');
        int i=1;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push('(');
                ans+='(';
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    ans+=')';
                }
                else{
                    if(i+1<n){
                        st.push('(');
                        i++;
                    }
                }
            }
            i++;
        }
        return ans;
    }
}
