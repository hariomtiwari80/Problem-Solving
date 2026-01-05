class Solution {
    public int minDeletionSize(String[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        int m=arr[0].length(),cnt=0;
        boolean[] b=new boolean[n];
        for(int i=0;i<m;i++){
            boolean check=true;
            for(int j=1;j<n;j++){
                if(!b[j] && (int)(arr[j].charAt(i))<(int)(arr[j-1].charAt(i))){
                    check=false;
                    break;
                }
            }
            if(!check) cnt++;
            else{
                for(int j=1;j<n;j++){
                    if(!b[j] && (int)(arr[j].charAt(i))>(int)(arr[j-1].charAt(i))){
                        b[j]=true;
                    }
                }
            }
        }
        return cnt;
    }
}
