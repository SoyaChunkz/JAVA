import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    // print all permutations 0(n*n!)  
    // public static void printPerm(String str, String permu) {
    //     if( str.length() == 0){
    //         System.out.println(permu);
    //         return;
    //     }
    //     for (int i = 0; i < str.length(); i++) {
    //         char currChar = str.charAt(i);
    //         String newStr = str.substring(0, i) + str.substring(i+1);
    //         printPerm(newStr, permu+currChar);
    //     }
    // }

    // sudoku solver

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public static boolean isSafe(int row, int col, char[][] board, int number){

        // horizontal & vertical
        for (int i = 0; i < board.length; i++) {
            if( board[row][i] == (char)(number+'0'))
                return false;

            if( board[i][col] == (char)(number+'0'))
                return false;
        }

        // current grid
        int startrow = (row/3) * 3;
        int startcol = (col/3) * 3;

        for (int i = startrow; i < startrow+3; i++) {
            for (int j = startcol; j < startcol+3; j++) {
                if( board[i][j] == (char)(number+'0'))
                    return false;
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col){

        if( row==board.length){
            return true;
        }
        int nrow = 0;
        int ncol = 0;
        if( col!= board.length-1){
            nrow = row;
            ncol = col+1;
        }
        else{
            nrow = row+1;
            ncol = 0;
        }

        if( board[row][col]!='.'){  //bharahua hai to next cell me jaeyga
            return helper(board, nrow, ncol);
        }
        else{
            // khali hai to bharega current cell ko fir next me jayega
            for (int i = 1; i <= 9; i++) {
                if( isSafe(row, col, board, i)){
                    board[row][col] = (char)(i+'0');
                    if( helper(board, nrow, ncol))
                        return true;
                    else{
                        board[row][col] = ('.');

                    }
                }
            }
        }
        return false;
    }

    public static void sudokuSolver(char[][] board){
        if(helper(board, 0, 0)){
            printBoard(board);
        }
        else{
            System.out.println("No solution");
        }
    }


    // nQueens

    public static Boolean isSafe(int row,int col, char[][] board){

        //horizontal
        for (int j = 0; j < board.length; j++) {
            if( board[row][j]=='Q')
                return false;
        }

        //vertical
        for (int i = 0; i < board.length; i++) {
            if( board[i][col]=='Q')
                return false;
        }

        //topleft
        
        for (int r = row, c = col; c>=0 && r>=0; c--, r--) {
            if( board[r][c]=='Q')
                return false;
        }

        //topright
        for (int r = row, c = col; c<board.length && r>=0; c++, r--) {
            if( board[r][c]=='Q')
                return false;
        }

        //bottomleft
        for (int r = row, c = col; c>=0 && r<board.length; c--, r++) {
            if( board[r][c]=='Q')
                return false;
        }

        //bottomright
        for (int r = row, c = col; c<board.length && r<board.length; c++, r++) {
            if( board[r][c]=='Q')
                return false;
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allboards){

        String row = "";
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if( board[i][j]=='Q')
                    row += 'Q';
                else
                    row += '.';

                }
            newBoard.add(row);    
        }
        allboards.add(newBoard);    
    }

    public static void helper(char[][] board, List<List<String>> allboards, int row,  int col){

        if( col==board.length){
            saveBoard(board, allboards);
            return; 
        }
        for (int i = 0; i < board.length; i++) {
            if(isSafe(i, col, board)){
                board[i][col] = 'Q';
                helper(board, allboards, 0, col+1);
                board[i][col] = '.';

            }
        }
    }

    public static List<List<String>> solveNQueens(int n){
        if( n==2 || n==3 )
            System.out.println("No possible solution");
        
        List<List<String>> allboards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allboards, 0, 0);
        return allboards;
    } 
    public static void main(String[] args) {
        // printPerm("ABC", "");
        // List<List<String>> ans = solveNQueens(3); // ans is a list containing 2lists of of 4strings  |  ans.size() is 2
        // for (int i = 0; i < ans.size(); i++) {
        //     List<String> board = ans.get(i);        // i is 1list of 4strings ie i is a board
        //     // System.out.println(board);
        //     for (int j = 0; j < board.size(); j++) {
        //         System.out.println(board.get(j));
        //     }
        //     System.out.println();
        // }
        // System.out.println(ans);



        // char[][] board = new char[9][9];
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        sudokuSolver(board);


    }
}
