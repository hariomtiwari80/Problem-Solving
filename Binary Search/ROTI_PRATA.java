import java.util.*;

public class ROTI_PRATA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int p=sc.nextInt();
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            int l=1,h=p*(p+1)/2;
            int ans=0;
            while(l<=h){
                int m=l+(h-l)/2;
                if(valid(arr,m,p)){
                    ans=m;
                    h=m-1;
                }
                else l=m+1;
            }
            System.out.println(ans);
        }
    }
    public static boolean valid(int[] arr,int m,int p){
        int t=0;
        for(int x:arr){
            int time=0,i=1,count=0;
            while(time<m){
                time+=x*i;
                if(time>m) break;
                i++;
                count++;
            }
            t+=count;

        }
        return t>=p;
    }
}