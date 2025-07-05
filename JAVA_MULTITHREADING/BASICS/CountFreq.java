package DSA.BASICS;

import java.util.*;

public class CountFreq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Enter " + (i + 1) + " element: ");
            nums[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for( int num : nums ){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for( Map.Entry<Integer, Integer> entrySet : map.entrySet() ){
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }

        sc.close();
    }

}
