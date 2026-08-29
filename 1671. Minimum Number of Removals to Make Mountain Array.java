class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] lcs=new int[n];
        Arrays.fill(lcs,1);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    lcs[i]=Math.max(lcs[i],lcs[j]+1);
                }
            }
        }
        int[] lds=new int[n];
        Arrays.fill(lds,1);
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    lds[i]=Math.max(lds[i],lds[j]+1);
                }
            }
        }
        for(int x:lcs) System.out.print(x+" ");
        System.out.println();
        for(int x:lds) System.out.print(x+" ");
        int max=0;
        for(int i=1;i<n-1;i++){
            if(lcs[i]!=1 && lds[i]!=1) max=Math.max(max,lcs[i]+lds[i]-1);
        }
        return n-max;
    }
}
