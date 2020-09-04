import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();
        int[] ar = new int[n];
        System.out.println("Enter the elements of the array in range(0-20): ");
        for(int i=0;i<n;i++){
            ar[i] = scanner.nextInt();
        }
        int[] countingSort = new int[21];
        for(int i=0;i<n;i++){
            countingSort[ar[i]]+=1;
        }
        int idx =0;
        for(int i=0;i<=20;++i){
            for(int j=0;j<countingSort[i];++j){
                ar[idx] = i;
                idx++;
            }
        }
        System.out.println("Modified Array: ");
        for(int i=0;i<n;++i){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
}
