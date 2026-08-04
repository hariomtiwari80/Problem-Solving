class Solution {
    public int maxDepth(String s) {
        int num=0,c=0,max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
                max=Math.max(max,c);
            }
            else if(s.charAt(i)==')') c--;
        }
        return max;
    }
}
