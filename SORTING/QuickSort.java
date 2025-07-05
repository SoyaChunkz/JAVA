package SORTING;
public class QuickSort {

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

    public static int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = low-1;

        for (int j = low; j < high; j++) {
            if( arr[j]<pivot){  // compare with pivot
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, high);  // Move the pivot element to its correct position
        return i;
    }

    public static void quickSort(int arr[], int low,int high){

        if( low<high ){
            int pivotIdx = partition(arr, low, high);

            quickSort(arr, low, pivotIdx-1);
            quickSort(arr, pivotIdx+1, high);
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        quickSort(arr, 0, arr.length-1); // worst case O(n*n)  //  best case O(nlogn)
        printArray(arr, arr.length);
    }
}