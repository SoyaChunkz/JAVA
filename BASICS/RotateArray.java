package DSA.BASICS;

import java.util.*;
import DSA.BASICS.ReverseArray;

public class RotateArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Enter " + (i + 1) + " element: ");
            nums[i] = sc.nextInt();
        }

        System.out.println("By how much do you want to rotate? : ");
        int k = sc.nextInt();

        System.out.print("Before rotating -> ");

        for(int i=0; i<nums.length; i++ ){
            System.out.print(nums[i] + " " );
        }

        System.out.println();

        ReverseArray.reverseArray(0, size-1, nums);

        ReverseArray.reverseArray(0, k, nums);

        ReverseArray.reverseArray(k+1, size-1, nums);

        System.out.print("After  rotating -> ");
        for(int i=0; i<nums.length; i++ ){
            System.out.print(nums[i] + " " );
        }

    }
}
