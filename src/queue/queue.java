package queue;

public class queue {
    static class Queue{
        static int array[];
        static int size;
        static int rear=-1;
        Queue(int n){
            array=new int[n];
            this.size=n;
        }
        public static boolean isEmpty(){
            return rear==-1;

        }
        public static void add(int data){
            if(rear==size-1){
                System.out.println("full queue");
                return;
            }
            rear++;
            array[rear]=data;

        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front=array[0];
            for(int i=0;i<rear;i++){
                array[i]=array[i+1];
            }
            rear--;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queen");
                return -1;
            }
            int front=array[0];
            return front;
        }

    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
