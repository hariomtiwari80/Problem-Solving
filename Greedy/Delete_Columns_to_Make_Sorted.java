class Solution {
    public int minDeletionSize(String[] arr) {
        int n=arr.length,m=arr[0].length();
        if(n==1) return 0;
        int c=0;
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                if((int)(arr[i].charAt(j))<(int)(arr[i-1].charAt(j))){
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}
