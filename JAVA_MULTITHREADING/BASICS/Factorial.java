package DSA.BASICS;

import java.util.Scanner;

public class Factorial {

    public static int getFactorial(int num) {

        if (num == 0 || num == 1)
            return 1;

        return num * getFactorial(num - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Factorial of " + n + " is: " + getFactorial(n));
    }
}
