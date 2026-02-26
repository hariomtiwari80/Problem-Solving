class Solution {
    public int minTimeToType(String s) {
    int n=s.length();
    int ans=n;
    int p=97;
    for(int i=0;i<n;i++){
        int ch=(int)(s.charAt(i));
        int m1=Math.abs(p-ch);
        int m2=26-m1;
        ans+=Math.min(m1,m2);
        p=ch;
    }
    return ans;
    }
}
