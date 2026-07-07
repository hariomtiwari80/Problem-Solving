class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int l=0,r=0;
        while(r<s2.length()){
            char ch=s2.charAt(r);
            arr2[ch-'a']++;
            while(r-l+1>s1.length()){
                arr2[s2.charAt(l)-'a']--;
                l++;
            }
            if(same(arr1,arr2)) return true;
            r++;
        }
        return false;
    }
    public boolean same(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
