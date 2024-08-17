package SORTING;
public class MergeSort {

    public static void printArray(int arr[], int lambai){

        System.out.print("Sorted array is: ");
        int size = lambai;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }
    
    public static void conquer(int arr[], int si, int mid, int ei){

        int merged[] = new int[ei - si +1];
        int idx1 = si;
        int idx2 = mid+1;
        int idx = 0;
        while( idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merged[idx]=arr[idx1];
                idx++;
                idx1++;
            }
            else{
                merged[idx]=arr[idx2];
                idx++;
                idx2++;
            }
        }

        while (idx1<=mid) {
            
            merged[idx]=arr[idx1];
            idx++;
            idx1++;
        }
        while (idx2<=ei) {
            
            merged[idx]=arr[idx2];
            idx++;
            idx2++;
        }
        
        for (int i = 0, j = si; i < merged.length && j<arr.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int si, int ei){
        if( si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr, si, mid, ei);
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        divide(arr, 0, arr.length-1);
        printArray(arr, arr.length);
    }
}
