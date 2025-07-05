import java.util.*;
public class StackProbs{

    public static void pushAtBottom(int data, Stack<Integer> stack ){
        if( stack.isEmpty() ){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack){
        if( stack.isEmpty() )
            return;
        int top = stack.pop();
        reverse(stack);
        pushAtBottom(top, stack);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // pushAtBottom(4, stack);
        reverse(stack);
        while( !stack.isEmpty() ){
            System.out.print(stack.pop()+" ");
        }
        
    }
}