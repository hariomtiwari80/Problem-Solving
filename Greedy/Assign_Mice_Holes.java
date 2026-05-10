class Solution {
    public int assignHole(int[] mices, int[] holes) {
        int n=mices.length;
        Arrays.sort(mices);
        Arrays.sort(holes);
        int ans=0;
        for(int i=0;i<n;i++){
            if(holes[i]>mices[i]) ans=Math.max(ans,holes[i]-mices[i]);
            else ans=Math.max(ans,mices[i]-holes[i]);
        }
        return ans;
        
    }
}
