
import java.util.*;
public class ques5 {
    public static void union(int arr1[], int arr2[], int n)
    {
        boolean check[]= new boolean[n];
        for(int i=0; i<arr1.length; i++)
        {
            check[arr1[i]]= true;
        }
        for(int i=0; i<arr2.length; i++)
            check[arr2[i]]= true;
        System.out.print("A UNION B is: ");
        for(int i=0; i<n ; i++)
            if(check[i])
                System.out.print(i+" ");
        System.out.println();
    }
    public static void intersect(int arr1[], int arr2[], int n)
    {
        boolean check[]= new boolean[n];
        for(int i=0; i<arr1.length; i++)
        {
            check[arr1[i]]= true;
        }
        System.out.print("A INTERSECTION B is: ");
        for(int i=0; i<arr2.length; i++)
            if(check[arr2[i]])
                System.out.print(arr2[i]+" ");
        System.out.println();
    }
    public static void complement(int arr1[], int n)
    {
        boolean check[]= new boolean[n];
        for(int i=0; i<arr1.length; i++)
            check[arr1[i]]= true;
        System.out.print("The complement of the give set is:");
        for(int i=0; i<n; i++)
            if(check[i]==false)
                System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("numbers of elements in the universe. (E.g.: 2 for (0,1) ");
        n= sc.nextInt();

        System.out.print("No. of elements in Set A: ");
        int count1= sc.nextInt();
        System.out.println("Enter the elements of Set A!");
        int A[]= new int[count1];
        Set<Integer> setA= new HashSet<Integer>();
        Set<Integer> setB= new HashSet<Integer>();
        for(int i=0; i<count1; i++)
        {
            A[i]= sc.nextInt();
            setA.add(A[i]);
        }

        System.out.print("No. of elements in Set B: ");
        int count2= sc.nextInt();
        System.out.println("Enter the elements of Set B!");
        int B[]= new int[count2];
        for(int i=0; i<count2; i++)
        {
            B[i]= sc.nextInt();
            setB.add(B[i]);
        }
        sc.close();

        //using arrays	    
        long s1= System.nanoTime();
        System.out.println();
        System.out.println("Using Arrays: ");
        union(A, B, n);
        intersect(A,B,n);
        complement(A, n);
        complement(B, n) ;
        System.out.println();
        long e1= System.nanoTime();

        //using hash set
        long s2= System.nanoTime();
        System.out.println();
        System.out.println("Using Hash_Set: ");
        // To find union  
        Set<Integer> union = new HashSet<Integer>(setA);
        union.addAll(setB);
        System.out.print("A UNION B: ");
        System.out.println(union);
        // To find intersection  
        Set<Integer> intersection = new HashSet<Integer>(setA);
        intersection.retainAll(setB);
        System.out.print("A INTERSECTION B: ");
        System.out.println(intersection);
        //Complement
        Set<Integer> Universe= new HashSet<Integer>();
        for(int i=0; i<n; i++)
            Universe.add(i);
        Set<Integer> differenceSet = new HashSet<Integer>(Universe);
        differenceSet.removeAll(setA);
        System.out.print("Complement of Set A: ");
        System.out.println(differenceSet);

        differenceSet = new HashSet<Integer>(Universe);
        differenceSet.removeAll(setB);
        System.out.print("Complement of Set B: ");
        System.out.println(differenceSet);
        System.out.println();

        long e2= System.nanoTime();
        System.out.println("Cost of operations using ARRAY: "+ (e1-s1) + " ns");
        System.out.println("Cost of operations using HASH SET: "+ (e2-s2) + " ns");
        System.out.println();
    }
}
