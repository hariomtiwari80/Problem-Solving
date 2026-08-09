class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n=s.length();
        int[] arr=new int[n];
        int c0=0,c1=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(c0<=c1){
                    c0++;
                    arr[i]=0;
                }
                else{
                    c1++;
                    arr[i]=1;
                }
            }
            else{
                if(c0>=c1){
                    c0--;
                    arr[i]=0;
                }
                else{
                    c1--;
                    arr[i]=1;
                }
            }
        }
        return arr;
    }
}
