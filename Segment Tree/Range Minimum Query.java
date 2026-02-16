/* The functions which
builds the segment tree */
class GfG {
    static int tree[];

    public static int[] constructST(int arr[], int n) {
        tree=new int[4*n];
        build(arr,0,n-1,0,tree);
        return tree;
    }
    
    public static void build(int[] arr,int l,int h,int i,int[] tree){
        if(l==h){
            tree[i]=arr[h];
            return;
        }
        int m=(l+h)/2;
        build(arr,l,m,2*i+1,tree);
        build(arr,m+1,h,2*i+2,tree);
        tree[i]=Math.min(tree[2*i+1],tree[2*i+2]);
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int tree[], int n, int l, int r) {
        return query(tree,0,n-1,0,l,r);
    }
    public static int query(int[] tree,int l,int h,int i,int s,int e){
        if(l>e || h<s) return Integer.MAX_VALUE;
        if(l>=s && h<=e) return tree[i];
        int m=(l+h)/2;
        return Math.min(query(tree,l,m,2*i+1,s,e),query(tree,m+1,h,2*i+2,s,e));
    }
}
