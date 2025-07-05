import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args) {
        // Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.add(5);

        while( !q.isEmpty() ){
            System.out.print(q.remove()+" ");
        }
    }
}
