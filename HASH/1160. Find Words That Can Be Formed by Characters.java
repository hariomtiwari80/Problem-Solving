class Solution {
    public int countCharacters(String[] arr1, String s) {
        int n=arr1.length;
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<s.length();i++){
            freq2[s.charAt(i)-'a']++;
        }
        int c=0;
        for(int i=0;i<arr1.length;i++){
            String t=arr1[i];
            for(int j=0;j<t.length();j++){
                freq1[t.charAt(j)-'a']++;
            }
            if(same(freq1,freq2)) c+=t.length();
            Arrays.fill(freq1,0);
        }
        return c;
    }
    public boolean same(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]>arr2[i]) return false;
        }
        return true;
    }
}
