import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int sum=0,c=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=sum) {
                sum += arr[i];
                c++;
            }
        }
        System.out.print(c);
    }
}
