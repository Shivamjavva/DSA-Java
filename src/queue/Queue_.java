package queue;
import java.util.*;
public class Queue_ {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList();
        q.add(1);
        q.peek();
        q.add(2);
       // q.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
