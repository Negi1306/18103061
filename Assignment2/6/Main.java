import java.util.Scanner;
public class Hailstone {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number ");
        int n = scan.nextInt();

        System.out.println("Hailstone sequence is - " + n);
        int ct = 0;
        while(n!=1 && ct<Integer.MAX_VALUE && n<Integer.MAX_VALUE && n>0){
            if(n%2!=0){
                n=(n*3)+1;
            }
            else{
                n/=2;
            }
            System.out.println(n);
            ct++;
        }
        if(n==1){
            System.out.println("No of steps: "+ct);
        }
        else if(n==Integer.MAX_VALUE || n<0){
            System.out.println("Integer overflow ");
        }
        else{
            System.out.println("No of steps maxed out.");
        }
        scan.close();
    }
}
