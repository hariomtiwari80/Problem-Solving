class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length,m=potions.length;
        Arrays.sort(potions);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=find(spells[i],potions,success);
        }
        return arr;
    }
    public int find(int p,int[] potions,long s){
        int l=0,h=potions.length-1;
        int ans=potions.length;
        while(l<=h){
            int m=l+(h-l)/2;
            if((long)(potions[m])*p>=s){
                ans=m;
                h=m-1;
            }
            else l=m+1;
        }
        return potions.length-ans;
    }
}
