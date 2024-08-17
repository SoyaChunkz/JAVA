import java.util.HashSet;

public class RecursionProbs {

    public static void towerOfHanoi (int n, String src, String helper, String dest){

        if ( n == 1 ){
            System.out.println("transfer disk "+ n +" from " + src + " to " + dest); // last n ko dest pe daalo
            return;
        }

        towerOfHanoi(n-1, src, dest, helper); // n-1 ko src se helper pe daalo 
        System.out.println("transfer disk "+ n +" from " + src + " to " + dest); // last n ko dest pe daalo
        towerOfHanoi(n-1, helper, src, dest); // n-1 ko helper se dest pe daalo 
    }

    public static void revString(String str, int idx) {
        
        if ( idx == 0 ){
            System.out.print(str.charAt(idx));
            return;
        }

        System.out.print(str.charAt(idx));
        revString(str, idx-1);
    }

    public static int first = -1;
    public static int last = -1;
    public static void findOcc(String str, char elem, int idx) {
        
        if(idx == str.length())
            return;

        if (str.charAt(idx) == elem){
            if (first == -1)
                first = idx;
            else
                last = idx;
        }

        findOcc(str, elem, idx+1);
    }


    public static boolean isIncreasing(int arr[], int idx) {
        
        if(idx==arr.length-1)
            return true;

        if(arr[idx]<arr[idx+1]){
            return isIncreasing(arr, idx+1);
        }
        else
            return false;
    }

    public static void moveAllX(String str, int idx, int count, String newString) {

        if (idx == str.length()){
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        if (str.charAt(idx)== 'x'){
            moveAllX(str, idx+1, count+1, newString);
        }
        else{
            newString += str.charAt(idx);
            moveAllX(str, idx+1, count, newString);
        }
        
    }

    public static boolean map[] = new boolean[26];

    public static void removeDups(String str, int idx, String newString) {

        if( idx == str.length()){
            System.err.println(newString);
            return;
        }

        if( map[str.charAt(idx)-'a'] == true){
            removeDups(str, idx+1, newString);
        }
        else{
            newString += str.charAt(idx);
            map[str.charAt(idx)-'a'] = true;
            removeDups(str, idx+1, newString);
        }
    }

    public static void printSubString(String str, int idx, String newString) {
        if( idx==str.length()){ 
            System.out.println(newString); 
            return; } 
            //te bo 
            printSubString(str, idx+1, newString+str.charAt(idx)); 
            //not to be 
            printSubString(str, idx+1, newString); 
        }

    public static void printSubStringUnique(String str, int idx, String newString, HashSet<String> allSubseq) {
        if( idx==str.length()){ 
            if( allSubseq.contains(newString))
                return;
            else{
                allSubseq.add(newString);
                System.out.println(newString); 
                return; 
                }
            } 
            //te bo 
        printSubStringUnique(str, idx+1, newString+str.charAt(idx), allSubseq); 
            //not to be 
        printSubStringUnique(str, idx+1, newString, allSubseq); 
        }

    public static String[] keypad= {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKeypadComs(String str, int idx, String coms) {
        
        if(idx == str.length()) {
            System.out.println(coms);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            printKeypadComs(str, idx+1, coms + mapping.charAt(i));
        }
    }

        
    
    public static void main(String[] args) {
        // int n = 3;
        // towerOfHanoi(n, "S", "H", "D");

        // String str = "GameKarDunga";
        // int idx = str.length()-1;
        // revString(str, idx);

        // String str = "tabcdfghijakkk";
        // char elem = 'a';
        // findOcc(str, elem, 0);
        // System.out.println("First occ: " + first);
        // System.out.println("Last occ: " + last);

        // int arr[] = {1,2,3,4,4};
        // System.out.println(isIncreasing(arr, 0));

        // String str = "abcdefxghxixjxxxk";
        // moveAllX(str, 0, 0, "");

        // String str = "abcadbcefghabi";
        // removeDups(str, 0, "");
        // for (int i = 0; i < map.length; i++) {
        //     System.out.print(map[i]+" ");
        // }

        // String str = "abc";
        // String str1 = "aaa";
        // HashSet<String> allSubseq = new HashSet<>();
        // printSubStringUnique(str1, 0, "", allSubseq);
        
        String str = "23";
        printKeypadComs(str, 0, "");

        
    }
}