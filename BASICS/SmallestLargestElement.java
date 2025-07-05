package DSA.BASICS;
import java.util.*;

public class SmallestLargestElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        for(int i=0; i<nums.length; i++ ){
            System.out.println("Enter " + (i+1) + " element: ");
            nums[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for( int num : nums ){
            if( num < min )
                min = num;
        }

        for( int num : nums ){
            if( (num < secondSmallest) && (num != min)  )
                secondSmallest = num;
        }

        System.out.println("Smallest element is :" + min);
        System.out.println("Second smallest element is :" + secondSmallest);


        int max = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for( int num : nums ){
            if( num > max )
                max = num;
        }

        for( int num : nums ){
            if( (num > secondLargest) && (num != max)  )
                secondLargest = num;
        }

        System.out.println("Largest element is :" + max);
        System.out.println("Second largest element is :" + secondLargest);

    }
}

