package SORTING;

public class MergeSort2 {

    public static void merge(int[] arr, int[] left, int[] right){

        int i=0;
        int j=0;

        int k = 0;

        while( i < left.length && j < right.length ){

            if( left[i] <= right[j] ){
                arr[k] = left[i];
                i++;
                k++;
            }
            else{
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while( i < left.length ){
            arr[k] = left[i];
            i++;
            k++;
        }
        while( j < right.length ){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr){

        if( arr.length < 2 ) return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for( int i=0; i<mid; i++ ){
            left[i] = arr[i];
        }
        for( int j=mid; j<arr.length; j++ ){
            right[j - mid] = arr[j];
        }

        mergesort(left);
        mergesort(right);

        merge(arr, left, right);
    }
    
    public static void main(String[] args) {
        
        int arr[] = {9,8,7,6,5,4,3,2,1};

        mergesort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}


/*Initial Array: [9, 8, 7, 6, 5, 4, 3, 2, 1]

Step 1: Split into [9, 8, 7, 6] and [5, 4, 3, 2, 1]

Step 2: Split [9, 8, 7, 6] into [9, 8] and [7, 6]
        Split [5, 4, 3, 2, 1] into [5, 4] and [3, 2, 1]

Step 3: Split [9, 8] into [9] and [8]
        Split [7, 6] into [7] and [6]
        Split [5, 4] into [5] and [4]
        Split [3, 2, 1] into [3] and [2, 1]

Step 4: Split [2, 1] into [2] and [1]

Step 5: Merge [9] and [8] into [8, 9]
        Merge [7] and [6] into [6, 7]
        Merge [5] and [4] into [4, 5]
        Merge [2] and [1] into [1, 2]

Step 6: Merge [8, 9] and [6, 7] into [6, 7, 8, 9]
        Merge [4, 5] and [1, 2, 3] into [1, 2, 3, 4, 5]

Step 7: Merge [6, 7, 8, 9] and [1, 2, 3, 4, 5] into [1, 2, 3, 4, 5, 6, 7, 8, 9]

Final Sorted Array: [1, 2, 3, 4, 5, 6, 7, 8, 9]*/
