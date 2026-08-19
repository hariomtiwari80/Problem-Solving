
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long t=sc.nextLong();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i=0,j=0,max=0;
        long sum=0;
        while(j<n){
            sum+=arr[j];
            if(sum>t){
                max=Math.max(max,j-i);
                while(sum>t) {
                    sum -= arr[i];
                    i++;
                }
            }
            j++;
        }
        max=Math.max(max,n-i);
        System.out.print(max);
    }
}
