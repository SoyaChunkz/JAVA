public class RecursionAdv {

    public static void printPerm(String str, String permu){ 
        // 0(n!)

        if( str.length()==0){
            System.out.println(permu);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPerm(newStr, permu+currChar);
        }
    }

    public static int printPaths( int i, int j, int m, int n){

        if(i==m || j==n)
            return 0;
        
        if(i==m-1 && j==n-1)
            return 1;
        int downwards = printPaths(i+1, j, m, n);

        int righwards = printPaths(i, j+1, m, n);

        System.out.println(downwards + " " + righwards);
        return downwards+righwards;
    }

    public static int placeTiles(int r, int c){

        if( c==r )
            return 2;
        if( c>r )
            return 1;
        int horizontal = placeTiles(r-1, c);
        int vertical = placeTiles(r-c, c);

        return horizontal + vertical;
    }

    public static int party(int n) {
        
        if( n<=1 )
            return 1;
        int single = party(n-1);
        int pairs = (n-1) * party(n-2);

        return single+pairs;
    }
    public static void main(String[] args) {
        // printPerm("abc", "");
        // System.out.println(printPaths(0, 0, 3, 3));
        // System.out.println(placeTiles(4, 3));
        System.out.println(party(3));
    }
}