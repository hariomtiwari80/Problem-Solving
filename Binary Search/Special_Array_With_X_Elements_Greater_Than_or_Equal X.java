class Solution {
    public int specialArray(int[] arr) {
        for(int i=1;i<=arr.length;i++){
            int c=0;
            for(int x:arr){
                if(x>=i) c++;
            }
            if(c==i) return c;
        }
        return -1;
    }
}

--------------------------------------------------

class Solution {
    public int specialArray(int[] arr) {
        int n=arr.length;
        int l=1,h=n;
        while(l<=h){
            int m=l+(h-l)/2;
            int find=call(arr,m);
            if(find==m) return m;
            else if(find>m) l=m+1;
            else h=m-1;
        }
        return -1;   
    }
    public int call(int[] arr,int m){
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=m) c++;
        }
        return c;
    }
}
