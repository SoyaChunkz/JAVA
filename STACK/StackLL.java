public class StackLL {
    
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{

        public static Node head = null;

        public boolean isEmpty(){
            
            return head==null;
        }

        public void push(int data){

            Node newNode = new Node(data);
            
            if( head==null ){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if( isEmpty() )
                return -1;

            Node top = head;
            head = head.next;
            return top.data;
        }

        public int peek(){
            if( isEmpty() )
                return -1;
            
            Node top = head;
            return top.data;

        }

    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isEmpty());

        while( !stack.isEmpty() ){
            System.out.print (stack.pop()+" ");
        }

    }
}
