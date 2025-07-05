package DSA.BASICS;
import java.util.*;

class ReverseArray {

    public static void reverseArray(int left, int right, int arr[]){

        while( left < right ){
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];

            left++; right--;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        for(int i=0; i<nums.length; i++ ){
            System.out.println("Enter " + (i+1) + " element: ");
            nums[i] = sc.nextInt();
        }

        ReverseArray.reverseArray(0, size-1, nums);

        for(int i=0; i<nums.length; i++ ){
            System.out.print(nums[i] + " " );
        }

    }
}