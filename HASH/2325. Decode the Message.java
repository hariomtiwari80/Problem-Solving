class Solution {
    public String decodeMessage(String key, String mess) {
        HashMap<Character,Character> map=new HashMap<>();
        int ascii=97;
        for(int i=0;i<key.length();i++){
            char ch=key.charAt(i);
            if(ch==' ') continue;
            if(!map.containsKey(ch)){
                map.put(ch,(char)(ascii));
                ascii++;
            }
        }
        String s="";
        for(int i=0;i<mess.length();i++){
            char c=mess.charAt(i);
            if(c==' ') s+=" ";
            else{
                s+=map.get(mess.charAt(i));
            }
        }
        return s;
    }
}
