class Solution {
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        int[] tree=new int[4*n];
        build(arr,0,n-1,0,tree);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<q*2;i+=2){
            ans.add(query(tree,0,0,n-1,queries[i]-1,queries[i+1]-1));
        }
        return ans;
    }
    void build(int[] arr,int l,int h,int i,int[] tree){
        if(l==h){
            tree[i]=arr[l];
            return;
        }
        int m=(l+h)/2;
        build(arr,l,m,2*i+1,tree);
        build(arr,m+1,h,2*i+2,tree);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }
    int query(int[] tree,int i,int l,int h,int s,int e){
        if(l>e || h<s) return 0;
        if(l>=s && h<=e) return tree[i];
        int m=(l+h)/2;
        return query(tree,2*i+1,l,m,s,e) + query(tree,2*i+2,m+1,h,s,e);
    }
}
