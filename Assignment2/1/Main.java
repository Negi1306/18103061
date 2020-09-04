import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int compStr(String st1, String st2) {
        for(int i=0;i<st1.length() && i<st2.length();i++){
            if((int)st1.charAt(i) == (int)st2.charAt(i)) continue;
            else return (int)s1.charAt(i)-(int)s2.charAt(i);
        }
        if(st1.length()<st2.length()){
            return st1.length()-st2.length();
        } else if(st1.length()>st2.length()){
            return st1.length()-st2.length();
        } else return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String s1 = input.next();
        System.out.print("Enter Second String: ");
        String s2 = input.next();
        System.out.println(compStr(s1,s2));

    }
}
