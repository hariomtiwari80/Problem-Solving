class Solution {
    public double medianOf2(int a[], int b[]) {
        int n=a.length,m=b.length;
        
        int[] arr=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                arr[k++]=a[i];
                i++;
            }
            else{
                arr[k++]=b[j];
                j++;
            }
        }
        while(i<n) arr[k++]=a[i++];
        while(j<m) arr[k++]=b[j++];
        int s=m+n;
        if(s%2!=0) return (double)arr[s/2];
        else{
            int n1=arr[s/2];
            int n2=arr[s/2-1];
            return (n1+n2)/2.0;
        }
    }
}

---------------------------------------------------------------------

class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
        return findMedianSortedArrays(arr2, arr1);

        int n=arr1.length,m=arr2.length;
        int l=0,h=n;
        while(l<=h){
            int m1=l+(h-l)/2; 
            int m2=(n+m+1)/2 - m1; 
            int x1=m1==0?Integer.MIN_VALUE:arr1[m1-1];
            int x2=m2==0?Integer.MIN_VALUE:arr2[m2-1];
            int x3=m1==n?Integer.MAX_VALUE:arr1[m1];
            int x4=m2==m?Integer.MAX_VALUE:arr2[m2];

            if(x1<=x4 && x2<=x3){
                if((m+n)%2!=0){
                    return (double)Math.max(x1,x2);
                }
                else{
                    return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
                }
            }
            else if(x1>x4) h=m1-1;
            else l=m1+1;
        }
        return 0;
    }
}
