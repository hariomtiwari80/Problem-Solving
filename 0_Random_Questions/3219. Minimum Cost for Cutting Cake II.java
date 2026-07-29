class Solution {
    public long minimumCost(int m, int n, int[] hor, int[] ver) {
        long ans=0;
        int h=1,v=1;
        Arrays.sort(hor);
        Arrays.sort(ver);
        int i=m-2,j=n-2;
        while(i>=0 && j>=0){
            if(hor[i]>ver[j]){
                h++;
                ans+=hor[i]*v;
                i--;
            }
            else{
                v++;
                ans+=ver[j]*h;
                j--;
            }
        }
        while(i>=0){
           ans+=hor[i]*v;
            i--; 
        }
        while(j>=0){
            ans+=ver[j]*h;
            j--;
        }
        return ans;
    }
}
