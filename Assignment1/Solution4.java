import java.util.*;
public class Solution4
{
    private static String sortStr(String str) { 
        char tmpArr[] = str.toCharArray(); 
        Arrays.sort(tmpArr); 
        return new String(tmpArr); 
    } 
    private static boolean isAnagram(String str1,String str2) {
        str1=sortStr(str1);
        str2=sortStr(str2);
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
            return false;
        }
        return true; 
    }
    public static void main(String []args) {
        Scanner scan=new Scanner(System.in);
        String s1,s2;
        boolean result;
        s1=scan.nextLine();
        s2=scan.nextLine();
        result=isAnagram(s1,s2);
        if(result==true) {
            System.out.println("These are Anagrams");
        }
        else {
            System.out.println("These are not Anagrams");
        }
    }
}