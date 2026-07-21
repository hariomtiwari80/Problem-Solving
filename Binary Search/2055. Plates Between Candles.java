class Solution {
    public int[] platesBetweenCandles(String s, int[][] arr) {
        int n=s.length();
        int idx=0;
        int[] ans=new int[arr.length];
        long[] pre=new long[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*') c++;
            pre[i]=c;
        }
        int[] left=new int[n];
        int[] right=new int[n];
        int curr=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='|') curr=i;
            left[i]=curr;
        }
        curr=-1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='|') curr=i;
            right[i]=curr;
        }

        for(int[] a:arr){
            int first=right[a[0]],last=left[a[1]];
            if(first==-1 || last==-1 || first>=last){
                ans[idx++]=0;
                continue;
            }
            ans[idx++]=(int)(pre[last]-pre[first]);

        }
        return ans;
    }
}
