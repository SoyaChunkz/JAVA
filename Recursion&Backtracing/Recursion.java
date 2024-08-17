
public class Recursion {

    public static void printRevNum(int n){
        if(n == 0)
            return;
        System.out.println(n);
        printRevNum(n-1);
    }

    public static void printNum(int n){
        if(n == 6)
            return;
        System.out.println(n);
        printNum(n+1);
    }
    
    public static void printSum(int n, int sum){
        if( n == 0){
            System.out.println(sum);
            return;
        }
        sum = sum + n;
        printSum(n-1, sum);
    }

    public static int printFact(int n){

        if (n == 0 || n == 1)
            return 1;

        int fibo_nm1 = printFact(n-1);
        return n*fibo_nm1;
    }

    public static void printFibo(int a, int b, int n){
        if( n == 0)
            return;
        int c = a + b;
        System.out.println(c);
        printFibo(b, c, n-1);
    }

    public static int printPower(int x, int n){

        // 0(n)
        if( n == 0)
            return 1;

        if( x == 0)
            return 0;

        int xm1 = printPower(x, n-1);
        return x * xm1;
    }

    public static int morePower(int x, int n){

        // 0(logn)
        if ( x == 0 )
            return 0;

        if ( n == 0 )
            return 1;

        if ( n%2 == 0){
            return morePower(x, n/2) * morePower(x, n/2);
        }

        else {
            return morePower(x, n/2) * morePower(x, n/2) * x;

        }
    }
    public static void main(String[] args) {

    // int n = 1;
    // printRevNum(n);
    // printNum(n);

    // int n = 5;
    // printSum(n, 0);

    // int n = 1;
    // System.out.println(printFact(n));

    // int n = 7;
    // int a = 0, b = 1;
    // System.out.println(a);
    // System.out.println(b);
    // printFibo(a, b, n-2);

    int x = 2;
    int n = 5;
    System.out.println(printPower(x, n));
    System.out.println(morePower(x, n));
   }
}
