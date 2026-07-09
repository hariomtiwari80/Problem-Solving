class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<List<Character>> l=new ArrayList<>();
        for(char i:map.keySet()){
            List<Character> temp=new ArrayList<>();
            int n=map.get(i);
            temp.add((char)(n+'0'));
            temp.add(i);
            l.add(temp);
        }
        Collections.sort(l,(a,b)->b.get(0)-a.get(0));
        String ans="";
        for(int i=0;i<l.size();i++){
            char ch=l.get(i).get(1);
            int n=(int)(l.get(i).get(0)-'0');
            for(int j=1;j<=n;j++){
                ans+=ch;
            }
        }
        return ans;
    }
}

------------------------------------------------------------------------------------------------

class Solution {
    class Pair{
        int f;
        char ch;
        Pair(int f,char ch){
            this.f=f;
            this.ch=ch;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Pair> l=new ArrayList<>();
        for(char i:map.keySet()){
            l.add(new Pair(map.get(i),i));
        }
        Collections.sort(l,(a,b)->b.f-a.f);
        String ans="";
        for(int i=0;i<l.size();i++){
            int n=l.get(i).f;
            char c=l.get(i).ch;
            for(int j=1;j<=n;j++){
                ans+=c;
            }
        }
        return ans;
    }
}
