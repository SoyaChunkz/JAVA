package SORTING;

import java.util.Random;

public class QuickSort2 {

    public static void printArray(int arr[]){

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();

    }

    public static void swap(int[] arr, int idx1, int idx2){

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void quicksort(int[] arr){
        quicksort(arr, 0, arr.length-1);
    }

    public static void quicksort(int[] arr, int lowIndex, int highIndex){

        if( lowIndex >= highIndex ) return;

        int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while( leftPointer < rightPointer ){

            while( arr[leftPointer] <= pivot && leftPointer < rightPointer ){
                leftPointer++;
            }
            while( arr[rightPointer] >= pivot && rightPointer > leftPointer ){
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }

        swap(arr, leftPointer, highIndex);

        quicksort(arr, lowIndex, leftPointer-1);
        quicksort(arr, leftPointer+1, highIndex);

    }
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Before");
        printArray(arr);

        quicksort(arr);
        System.out.println("After");
        printArray(arr);

    }
}
