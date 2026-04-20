package Hashing;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
public class hashing {
    public static void main(String[] args) {
        // Hashset  set doesnot allow duplicate unordered
        // insert add - O(1)
        // search conatins-0(1)
        // delete remove-O(1)
        // creation
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        // search
        if(set.contains(1)){
            System.out.println("contains 1");
        // delete
            }
        set.remove(1);
        System.out.println(set);
        //set.size( ) for size
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }




}
