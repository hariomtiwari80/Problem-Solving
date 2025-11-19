class Solution {
    public String shiftingLetters(String s, int[][] arr) {
        int n=s.length();
        int[] diff=new int[n];
        for(int[] a:arr){
            int l=a[0],r=a[1],x=a[2];
            if(x==0){
                if(l>=0 && l<n) diff[l]-=1;
                if(r>=0 && r+1<n) diff[r+1]+=1;
            }
            else if(x==1){
                if(l>=0 && l<n) diff[l]+=1;
                if(r>=0 && r+1<n) diff[r+1]-=1;
            }
        }
        int[] pre=new int[n];
        pre[0]=diff[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+diff[i];
        }
        String ans="";
        for(int i=0;i<n;i++){
            int t=pre[i]%26;
            if(t<0){
                t+=26;
            }
            ans+=(char)(((s.charAt(i)-'a')+t)%26 + 'a');
        }
        return ans;
    }
}
