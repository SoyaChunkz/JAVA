package DSA.BASICS;

import java.util.Scanner;

public class PalindromeNumber {

    public static boolean isPalindrome(int n){

        if (n < 0) 
            return false;

        if (n >= 0 && n <= 9)
            return true;
        
        int original = n;
        int reversed = 0;

        while( n > 0 ){

            int currDig = n % 10;
            reversed = reversed * 10 + currDig;
            n = n / 10;
        }

        return original == reversed;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println(isPalindrome(n));
    }
}
