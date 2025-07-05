import java.util.*;
public class LLProbs {
    
    Node head;
    private int size;

    LLProbs(){
        System.out.println("LL created");
        size = 0;
    }

    public class Node{

        int data;
        Node next;

        Node(int data){
            size++;
            System.out.println("Node created");
            this.data = data;
            this.next = null;
        }
    }

        // add from front
    public void addFirst(int data){

        Node newNode = new Node(data);
        if( head==null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add from behind
    public void addLast(int data){
        Node newNode = new Node(data);

        if( head==null){
            head = newNode;
            return;
        }

        Node lastNode = head;   // dummy node banaya traverse karne keliye
        while( lastNode.next!=null ){
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }

    // print
    public void printList(){

        Node currNode = head;  // dummy node

        while( currNode!=null ){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // delete from front
    public void removeFirst(){
        if( head==null ){
            System.out.println("Empty LL");
            return;
        }
        head = head.next;
        size--;
    }

    // delete from last
    public void removeLast(){

        if( head==null ){
            System.out.println("Empty LL");
            return;
        }

        size--;                  // ye pehle karna padega nahi to vo return ho jayega
        if( head.next == null){  // ek node hua to 
            head = null;
            return;
        }
        Node secondLastNode = head;  
        Node lastNode = head.next; 
        while( lastNode.next!=null ){  // ye tabtak chalega jab tak LL ke last node pe na ajaye
            secondLastNode = secondLastNode.next;
            lastNode = lastNode.next;
        }       
        secondLastNode.next = null;
    }

    // get size
    public int getSize(){
        // System.out.println("Size of LL is "+size);
        return size;
    }

    // search element
    public void getIndex(int elem){

        if( head==null ){
            System.out.println("Empty LL");
            return;
        }

        Node currNode = head;
        int count = 0;
        while( currNode!=null ){
            if( currNode.data == elem ){
                System.out.println("Element " + elem + " found at index " + count);
                return;
            }
            currNode = currNode.next;
            count++;
        }
        System.out.println("Element not found");
    }

    // add elements by user
    public void addElems(){

        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();
        if( elem<=50 )
            addLast(elem);
        else
            addElems();
    }
    
    public void delAboveLimit(int limit){

        if( head==null ){
            System.out.println("Empty LL");
            return;
        }
        if( head.next == null ){ // single elem
            if (head != null && head.data > limit) { // checking the first elem
                size--;
                head = null;
                return;
            }
        }

        Node prevNode = head;
        Node midNode = head.next;
        while (head != null && head.data > limit) { // checking the first elem
            size--;
            head = head.next;
        }
        while( midNode!=null ){
            Node nextNode = midNode.next;
            if( midNode.data > limit ){
                size--;
                prevNode.next = nextNode; // midnode ko hatao
                midNode = nextNode;
            }
            else{
                prevNode = midNode;
                midNode = nextNode;
            }
        }
    }
    public static void main(String[] args) {
        LLProbs list = new LLProbs();
        list.addElems();
        list.addElems();
        list.addElems();
        list.addElems();
        list.addElems();
        list.delAboveLimit(25);
        // list.addLast(1);
        // list.addLast(5);
        // list.addLast(7);
        // list.addLast(3);
        // list.addLast(8);
        // list.addLast(2);
        // list.addLast(3);
        // list.getIndex(7);
        // list.getIndex(70);
        list.printList();
        System.out.println(list.getSize());
        

    }
}
