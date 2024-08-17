import java.util.*;
public class StackAL {
    static class Stack{

        ArrayList<Integer> stack = new ArrayList<>();

        public boolean isEmpty(){
            return stack.size()==0;
        }

        public void push(int data){

            stack.add(data);
        }

        public int pop(){
            
            if( isEmpty() )
                return -1;
            
            int top = stack.remove(stack.size()-1);
            return top;
        }

        public int peek(){

            if( isEmpty() )
                return -1;

            int top = stack.size()-1;
            return top;
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
