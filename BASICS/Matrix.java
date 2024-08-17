package DSA.BASICS;
import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter Columns: ");
        int cols = sc.nextInt();

        int arr[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter "+i+j+" th value: ");
                arr[i][j] = sc.nextInt();
            
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // System.out.println("The "+i+j+" th value is: "+arr[i][j]);
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        int rowstart = 0,colstart=0;
        int rowend = rows-1, colend = cols-1;

        while (rowstart<=rowend && colstart<=colend) {
            for (int i = colstart; i <=colend; i++) {
                System.out.print(arr[rowstart][i]+" ");
            }
            rowstart++;

            for (int i = rowstart; i <=rowend; i++) {
                System.out.print(arr[i][colend]+" ");
            }
            colend--;

            for (int i = colend; i >=colstart; i--) {
                System.out.print(arr[rowend][i]+" ");
            }
            rowend--;

            for (int i = rowend; i >=rowstart; i--) {
                System.out.print(arr[i][colstart]+" ");
            }
            colstart++; 
        }

    }
}
