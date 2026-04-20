import java.util.HashSet;
import java.util.Iterator;
public class hashSet {
    public static void main(String[] args) {
        // insert add- big o 1
        // search big o 1
        // delete bo=ig o 1
        HashSet<Integer> set= new HashSet<>();
        // Insert
        set.add(1);
        set.add(2);
        set.add(3);
        // search-contains
        if(set.contains(1)){
            System.out.println("set contain 1");

        }
        // delete
        set.remove(1);
       if(! set.contains(1)){
           System.out.println("doesnot contains 1");
       }
        System.out.println("size of set is "+set.size());
        System.out.println(set);
        // iterator



    }
}
