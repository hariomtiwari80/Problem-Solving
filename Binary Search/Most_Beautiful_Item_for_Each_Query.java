class Solution {
    public int[] maximumBeauty(int[][] item, int[] q) {
        int n=q.length;
        Arrays.sort(item,(a,b)->a[0]-b[0]);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            for(int[] arr:item){
                if(arr[0]>q[i]) break;
                else{
                    max=Math.max(max,arr[1]);
                }
            }
            ans[i]=max;
        }
        return ans;
    }
}

---------------------------------------------------------------

class Solution {
    public int[] maximumBeauty(int[][] item, int[] q) {
        int n=q.length;
        int[] t=new int[n];
        for(int i=0;i<n;i++){
            t[i]=q[i];
        }
        Arrays.sort(t);
        Arrays.sort(item,(a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[n];
        int max=0,j=0;
        for(int i=0;i<n;i++){
            while(j<item.length && t[i]>=item[j][0]){
                max=Math.max(max,item[j][1]);
                j++;
            }
            map.put(t[i],max);
        }
        for(int i=0;i<n;i++){
            ans[i]=map.get(q[i]);
        }
        return ans;
    }
}
