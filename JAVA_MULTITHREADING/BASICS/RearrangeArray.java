package DSA.BASICS;

import java.util.*;

public class RearrangeArray {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Enter " + (i + 1) + " element: ");
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int i = nums.length-1; i >= nums.length / 2; i--) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
