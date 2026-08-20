package Infosys;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int open=0,c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else{
                if(open==0) c++;
                else open--;
            }
        }
        System.out.print(s.length()-(open+c));
    }
}
