package DSA.BASICS;

import java.util.Scanner;

public class ArmstrongNumber {

    public static boolean isArmstrong(int n){

        int original = n;
        int sum = 0;
        int length = getLength(original);

        while( n > 0 ){
            int currDig = n % 10;
            sum += Power.pow(currDig, length);
            n = n / 10;
        }

        return original == sum;
    }

    public static int getLength(int n){

        int length = 0;

        while( n > 0 ){
            length++;
            n = n / 10;
        }

        return length;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println( n + " is " + (isArmstrong(n) ? ("an ") : ("not an ")) + "Armstrong Number");
    }
}
