package SORTING;
import java.util.*;

public class Sorting {

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void printArray(int arr[], int lambai){

        System.out.print("Sorted array is: ");
        int size = lambai;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }

    public static void bubbleSort(int arr[], int lambai) {
        // bubble sort
        int size = lambai;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1); 
            }
        }
        
        printArray(arr, lambai);
    }

    public static void selectionSort(int arr[], int lambai) {
        // selection sort
        int size = lambai;
        for (int i = 0; i < size-1; i++) {
            int smallest = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j] < arr[smallest])
                    smallest = j;
            }
            swap(arr, smallest, i);
        }

        printArray(arr, lambai);
    }

    public static void insertionSort(int arr[], int lambai) {
        // insertion sort
        int size = lambai;
        for (int i = 1; i < size; i++) {
            int current = arr[i];
            int j = i-1;
            while (j>=0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;
        }

        printArray(arr, lambai);
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size");
        int lambai = sc.nextInt();
        int arr[] = new int[lambai];

        for (int i = 0; i < lambai; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr, lambai);
        selectionSort(arr, lambai);
        insertionSort(arr, lambai);

    }
}
