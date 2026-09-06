class Solution {
    public String getSmallestString(String s) {
        int n=s.length(),i=0;
        StringBuilder sb=new StringBuilder();
        while(i<n-1){
            if(s.charAt(i)>s.charAt(i+1)){
                if(sameParity(s.charAt(i),s.charAt(i+1))){
                    sb.append(s.charAt(i+1));
                    sb.append(s.charAt(i));
                    i+=2;
                    break;
                }
            }
            sb.append(s.charAt(i));
            i++;
        }
        while(i<n){
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
    public boolean sameParity(char c1,char c2){
        int a=c1-'0',b=c2-'0';
        if(a%2==0 && b%2==0) return true;
        if(a%2!=0 && b%2!=0) return true;
        return false;
    }
}
