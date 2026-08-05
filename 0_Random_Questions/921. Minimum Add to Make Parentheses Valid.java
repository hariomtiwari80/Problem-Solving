class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        if(n==1) return 1;
        Stack<Character> st=new Stack<>();
        int c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(ch);
            else{
                if(st.isEmpty()) c++;
                else st.pop();
            }
        }
        return st.size()+c;
    }
}
