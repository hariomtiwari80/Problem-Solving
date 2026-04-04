class NumArray {
    int[] seg;
    int n;
    public NumArray(int[] arr) {
        n=arr.length;
        seg=new int[4*n];
        build(arr,0,n-1,0);
    }
    public void build(int[] arr,int l,int h,int i){
        if(l==h){
            seg[i]=arr[l];
            return;
        }
        int m=(l+h)/2;
        build(arr,l,m,2*i+1);
        build(arr,m+1,h,2*i+2);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    
    public void update(int index, int val) {
        up(0,n-1,0,index,val);
    }
    public void up(int l,int h,int i,int id,int val){
        if(l==h){
            seg[i]=val;
            return;
        }
        int m=(l+h)/2;
        if(id<m+1) up(l,m,2*i+1,id,val);
        else up(m+1,h,2*i+2,id,val);
        seg[i]=seg[2*i+1]+seg[2*i+2]; 
    }
    
    public int sumRange(int left, int right) {
        return sum(0,n-1,0,left,right);
    }
    public int sum(int l,int h,int i,int ql,int qr){
        if(l>qr || h<ql) return 0;
        if(l>=ql && h<=qr) return seg[i];
        int m=(l+h)/2;
        int left=sum(l,m,2*i+1,ql,qr);
        int right=sum(m+1,h,2*i+2,ql,qr);
        return left+right;
    }
}
