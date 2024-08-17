package DSA.BASICS;
import java.util.*;

public class Stringz{
    public static void main(String[] args) {
        // String abc = "Java";
        // StringBuilder sb = new StringBuilder("isALanguage");
        // System.out.println(abc.getClass());
        // System.out.println(sb.getClass());

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());


        for (int i = 0; i < sb.length()/2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            char aageka = sb.charAt(front);
            char picheka = sb.charAt(back);

            sb.setCharAt(front, picheka);
            sb.setCharAt(back, aageka);
        }

        System.out.println(sb);
    }
}