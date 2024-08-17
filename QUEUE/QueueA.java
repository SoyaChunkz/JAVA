public class QueueA {
    static class Queue{
        static int arr[];
        static int rear;
        static int size;

        Queue(int n){
            this.size = n;
            arr = new int[n];
            rear = -1;

        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static boolean isFull(){
            return rear == size-1;
        }

        public static void add(int data){ //enqueue

            if( isFull() ){
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        public static int remove(){ //dequeue

            if( isEmpty() ){
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;

            return front;
        }

        public static int peek() { //peek
            
            if( isEmpty() ){
                return -1;
            }

            return arr[0];
        }
    }


    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while( !q.isEmpty() ){
            System.out.print(q.remove()+" ");
        }
    }
}
