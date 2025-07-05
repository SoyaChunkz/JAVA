package DSA.BASICS;

import java.util.Scanner;

public class PerfectNumber {

    public static boolean isPerfect(int n){

        int sum = 0;

        for (int i = 1; i < n; i++) {
            if( (n % i) == 0 )
                sum += i;
        }

        return sum == n;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println( n + " is " + (isPerfect(n) ? ("a ") : ("not a ")) + "Perfect Number");
    }
}
