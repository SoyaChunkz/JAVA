package DSA.BASICS;

import java.util.Scanner;

public class Power {

    public static int pow( int b, int e ){

        if( e == 0 ) return 1;

        if( e % 2 != 0 )
            return pow(b, e-1) * b;
        else{
            int halfPow = pow(b, e / 2);
            return halfPow * halfPow;
        }
            
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter base: ");
        int base = sc.nextInt();
        System.out.println("Enter exponent: ");
        int expo = sc.nextInt();

        System.out.println(base + " rasied to " + expo +" is: " + pow(base, expo));
    }
}
