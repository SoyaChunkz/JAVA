package DSA.BASICS;
import java.util.*;

public class Arrays{
    public static void main(String args[]){
        // int arr[] = new int[5];
        // arr[0] = 1;

        // int arr[] = {1,2,3,4,5};
        // int mul = 1;
        // for (int index = 0; index < arr.length; index++) {
        //     System.out.print(arr[index]); 
        //     if(index<=3)
        //         System.out.print('*');
        //     mul = mul*arr[index];
        // }
        // System.out.println();
        // System.out.println(mul); 



        // {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter size of array");
        // int size = sc.nextInt();
        // int arr[] = new int[size];

        // for (int i = 0; i < size; i++) {
        //     System.out.print("Enter "+ (i+1) +" th value: ");
        //     arr[i] = sc.nextInt();
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println("The "+ (i+1)+"th value is "+arr[i]);        
        // }
        // }

        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array");
            int size = sc.nextInt();
            int arr[] = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Enter "+ (i+1) +" th value: ");
                arr[i] = sc.nextInt();
            }

            int temp = 0;
            for (int i = 0; i < size-1; i++) {
                for (int j = 0; j < size-1-i; j++) {
                    if (arr[j]>arr[j+1]){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                    
                }
            }

            System.out.println("Sorted array");
            for (int i = 0; i < arr.length; i++) {
                    System.out.println("The "+ (i+1)+"th value is "+arr[i]);        
            }

            // here the i is the no of elements which has been sorted ie it is at its correct posn
            // i = 2 means last 2 elements are sorted
            // j is the element which is being sorted
            // j is compared from 0 -> size-1-i (-i bcoz i elements are already sorted)
            // 0-4  1-4  2-4  3-4  
        }
    }
}