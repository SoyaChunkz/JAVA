package DSA.BASICS;

import java.util.Scanner;
public class Primeno {

    public static boolean isPrime(int num) {
        if (num <= 1) return false; 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false; // Not prime if divisible by i
        }
        return true; // Number is prime
    }

    public static void main(String[] args) {
        
        // Scanner sc = new Scanner(System.in);

        // System.out.println("Enter size: ");
        // int size = sc.nextInt();

        // int[] nums = new int[size];

        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println("Enter " + (i+1) +" element: ");
        //     nums[i] = sc.nextInt();
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + ", ");
        // }

        
        // int sum = 0;

        // for (int num : nums) {
        //     if (isPrime(num)) {
        //         sum += num;
        //     }
        // }

        System.out.print("start->");
        int counter = 1;
        int i=2;
        while(counter <= 100){

            if( isPrime(i) ){

                System.out.print(i + "->");
                counter++;
            }
            i++;
        }
        System.out.print("end");

        System.out.println();

        // System.out.println("The sum is: " + sum);
    }
}