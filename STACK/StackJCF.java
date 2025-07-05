import java.util.*;
public class StackJCF {
    public static void main(String[] args) {
        Stack stack = new Stack<>();
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
