import java.util.*;
public class Magic_Powder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long k=sc.nextLong();
        long[] req=new long[n];
        for(int i=0;i<n;i++){
            req[i]=sc.nextLong();
        }
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        System.out.println(find(n,k,req,arr));
    }
    public static long find(int n,long k,long[] req,long[] arr){
        long l=0,h=(long)1e14,ans=0;
        while(l<=h){
            long m=l+(h-l)/2;
            if(valid(m,k,req,arr)){
                ans=m;
                l=m+1;
            }
            else h=m-1;
        }
        return ans;
    }
    public static boolean valid(long m,long k,long[] req,long[] arr){
        long need=0;
        for(int i=0;i<req.length;i++){
            long temp=req[i]*m;
            if(temp> arr[i]) need+=temp-arr[i];
        }
        return need<=k;
    }
}
