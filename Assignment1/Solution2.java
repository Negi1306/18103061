import java.util.*;
public class Solution2{
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter paragraph:");
        String paragraph=scan.nextLine();
        System.out.println("Enter the words to be replaced:");
        String wordsToBeReplaced=scan.nextLine();
        StringBuilder tempStrBuild=new StringBuilder();
        ArrayList<String>words=new ArrayList<String>();
        int n=wordsToBeReplaced.length(),i=0;
        while(i<n) {
            if(wordsToBeReplaced.charAt(i)==' ') {
                String tempStr=tempStrBuild.toString();
                words.add(tempStr);
                tempStrBuild=new StringBuilder();
            }
            else
                tempStrBuild.append(wordsToBeReplaced.charAt(i));
            i++;
        }
        String tempStr=tempStrBuild.toString();
        words.add(tempStr);
        StringBuilder sub;
        for(String s:words){
            sub = new StringBuilder();
            sub.append(s.charAt(0));
            for(i=0; i<s.length()-1; ++i)
                sub.append('*');
            s="\\b"+s+"\\b";
            paragraph=paragraph.replaceAll(s, sub.toString());
        }
        System.out.println(paragraph);
    }
}
