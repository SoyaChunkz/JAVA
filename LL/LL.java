class LL {
    
    Node head;
    private int size;

    LL(){
        System.out.println("LL Created");
        size = 0;
        
    }

    public class Node{

        String data;
        Node next;

        Node(String data){
            size++;
            System.out.println("Node created");
            this.data = data;
            this.next = null;
        }
    }

    
    // add from front
    public void addFirst(String data){

        Node newNode = new Node(data);
        if( head==null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add from behind
    public void addLast(String data){
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
    public void getSize(){
        System.out.println("Size of LL is "+size);
    }

    public static void main(String[] args) {
        LL list = new LL();
        System.out.println(list.size);
        list.addFirst("is");
        list.addFirst("name");
        list.addFirst("My");
        list.addLast("Java");
        list.removeFirst();
        list.removeLast();
        list.addFirst("The");
        list.addLast("JAVA");
        list.printList();
        list.getSize();
    }
}
