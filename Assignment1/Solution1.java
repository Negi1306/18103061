import java.util.*;
public class Solution1{
    public static String sortStr(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
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
        String pattern,givenStr;
        System.out.println("Enter the Text:");
        givenStr=scan.nextLine();
        System.out.println("Enter the Pattern to be Matched:");
        pattern=scan.nextLine();

        int p_hash=0,curr_hash=0;
        int begin=0,end=(pattern.length()-1);
        for(int i=0;i<pattern.length();i++){
            p_hash+=((int)pattern.charAt(i));
            if(i<=end)
                curr_hash+=((int)givenStr.charAt(i));
        }
        int N=givenStr.length(),count=0;
        while(end<N-1){
            if(curr_hash==p_hash){
                if(isAnagram(pattern,givenStr.substring(begin,end+1)))
                    count++;
            }
            curr_hash-=((int)givenStr.charAt(begin));
            curr_hash+=((int)givenStr.charAt(end+1));
            begin++;
            end++;
        }
        if(curr_hash==p_hash){
            if(isAnagram(pattern,givenStr.substring(begin,end+1)))
                count++;
        }
        System.out.println(count);
    }
}
