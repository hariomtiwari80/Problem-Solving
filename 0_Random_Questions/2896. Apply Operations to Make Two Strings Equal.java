class Solution {
    public List<Integer> l;
    public Integer[][] dp;
    public int minOperations(String s1, String s2, int x) {
        l=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) l.add(i);
        }
        if(l.size()%2!=0) return -1;
        dp=new Integer[l.size()+1][2];
        return find(0,0,x);
    }
    public int find(int i,int v,int x){
        if(i>=l.size()){
            if(v==1) return Integer.MAX_VALUE/2;
            return 0;
        }
        if(dp[i][v]!=null) return dp[i][v];
        int t1=Integer.MAX_VALUE/2;
        int t2=Integer.MAX_VALUE/2;
        if(i<l.size()-1){
            t1=l.get(i+1)-l.get(i)+find(i+2,v,x);
        }
        if(v==0) t2=find(i+1,1,x);
        else t2=x+find(i+1,0,x);
        return dp[i][v]=Math.min(t1,t2);
    }
}
