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

----------------------------------------------------------------------

class Solution {
    public int[] maximumBeauty(int[][] item, int[] q) {
        int n=q.length;
        Arrays.sort(item,(a,b)->a[0]-b[0]);
        int max=item[0][1];
        for(int i=1;i<item.length;i++){
            max=Math.max(max,item[i][1]);
            item[i][1]=max;
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=BinarySearch(item,q[i]);
        }
        return ans;
    }
    public int BinarySearch(int[][] item,int n){
        int l=0,h=item.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(item[m][0]>n) h=m-1;
            else l=m+1;
        }
        if (h<0) return 0;
        return item[h][1];
    }
}
