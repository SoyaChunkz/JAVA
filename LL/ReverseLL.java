import java.util.Collections;
import java.util.LinkedList;

public class ReverseLL {

    Node head;
    int size;

    ReverseLL() {

        size = 0;
        System.out.println("LL created");
    }

    class Node {

        int data;
        Node next;

        Node(int data) {

            size++;
            System.out.println("Node created");
            this.data = data;
            this.next = null;
        }
    }

    // add from front
    public void addFirst(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add from behind
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head; // dummy node banaya traverse karne keliye
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }

    // print
    public void printList() {

        Node currNode = head; // dummy node

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // delete from front
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty LL");
            return;
        }
        head = head.next;
        size--;
    }

    // delete from last
    public void removeLast() {

        if (head == null) {
            System.out.println("Empty LL");
            return;
        }

        size--; // ye pehle karna padega nahi to vo return ho jayega
        if (head.next == null) { // ek node hua to
            head = null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) { // ye tabtak chalega jab tak LL ke last node pe na ajaye
            secondLastNode = secondLastNode.next;
            lastNode = lastNode.next;
        }
        secondLastNode.next = null;
    }

    // get size
    public int getSize() {
        // System.out.println("Size of LL is "+size);
        return size;
    }

    // reverse a LL
    public void reverseIterate(){

        if( head==null || head.next==null ) // empty LL or single elem
            return;
        
        Node prevNode = head;
        Node currNode = head.next;
        while( currNode!=null ){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    
    public Node reverseRecursive(Node head){

        if(head == null || head.next == null) {
            return head;
        }
 
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        // ReverseLL list = new ReverseLL();
        // list.addFirst(1);
        // list.addFirst(2);
        // list.addFirst(3);
        // list.addFirst(4);
        // // list.reverseIterate();
        // list.printList();
        // list.head = list.reverseRecursive(list.head);
        // list.printList();




        // using COLLECTIONS FRAMEWORK
        LinkedList <Integer> list = new LinkedList<Integer>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
