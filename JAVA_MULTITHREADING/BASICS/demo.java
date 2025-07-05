package DSA.BASICS;
import java.util.*;

public class demo {
    public static void main(String[] args) {
        
        // String x = "ABC";
        // String a = new String(x);
        // String b = new String(x);

        String c = "ABC";
        String d = c;

        
        // System.out.println(a == b);
        // System.out.println(c == d);
        // System.out.println(c == x);
        // System.out.println(d == x);

        
        System.out.println(c.hashCode() + "---" + d.hashCode());
        d = d.toLowerCase();
        System.out.println(c.hashCode() + "---" + d.hashCode());

    }
}