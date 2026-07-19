class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int c=0;
        for(int x:arr1){
            int lower=find(arr2,x);
            if(lower==0){
                if(Math.abs(arr2[lower]-x)>d) c++;
            }
            else if(lower==arr2.length){
                if(Math.abs(arr2[lower-1]-x)>d) c++;
            }
            else{
                if(Math.abs(arr2[lower]-x)>d && Math.abs(arr2[lower-1]-x)>d) c++;
            }
        }
        return c;
    }
    public int find(int[] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
}
