//Brute Force
class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int ans=0;
        for(int i=2;i<n;i++){
            if(prime(i)) ans++;
        }
        return ans;
    }
    public boolean prime(int n){
        if(n==2) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
