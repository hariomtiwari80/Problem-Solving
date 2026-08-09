class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                c++;
                sb.append(ch);
            }
            else if(ch==')'){
                if(c>0){
                    sb.append(ch);
                    c--;
                }
            }
            else sb.append(ch);
        }
        if(c>0){
            for(int i=sb.length()-1;i>=0;i--){
                if(c==0) break;
                if(sb.charAt(i)=='(') {
                    sb.deleteCharAt(i);
                    c--;
                }
            }
        }
        return sb.toString();
    }
}
