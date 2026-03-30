class Solution {
    public int matchPlayersAndTrainers(int[] p, int[] t) {
        if(t.length==0) return 0;
        Arrays.sort(p);
        Arrays.sort(t);
        int j=0;
        int ans=0;
        for(int i=0;i<p.length;i++){
            while(j<t.length && p[i]>t[j]) j++;
            if(j==t.length) break;
            ans++;
            j++;
        }
        return ans;
    }
}
