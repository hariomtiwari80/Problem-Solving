class Solution {
    public int numberOfSpecialChars(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                map.put(ch,i);
            }
            else{
                if(!map.containsKey(ch)) map.put(ch,i);
            }
        }
        for(char ch:map.keySet()){
            if(ch>='a' && ch<='z'){
                int ascii=(int)ch;
                char c=(char)(ascii-32);
                if(map.containsKey(c)){
                    if(map.get(ch)<map.get(c)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
