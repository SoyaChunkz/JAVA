public class CircularQueueA {
    static class Queue{
        static int arr[];
        static int front ;
        static int rear ;
        static int size;

        Queue(int n){
            this.size = n;
            arr = new int[n];
            front = -1;
            rear = -1;

        }

        public static boolean isEmpty(){
            return (front == -1 && rear == -1);
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){ //enqueue

            if( isFull() ){
                System.out.println("Queue is full");
                return;
            }

            if( front == -1 )
                front = 0;
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public static int remove(){ //dequeue

            if( isEmpty() ){
                return -1;
            }
            int top = arr[front];
            if( front==rear ){
                front = rear = -1;
            }
            else{
                front = (front+1)%size;
            }
            return top;
        }

        public static int peek() { //peek
            
            if( isEmpty() ){
                return -1;
            }

            return arr[front];
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
