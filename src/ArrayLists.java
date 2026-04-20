import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    public static void main(String[] args) {
        // for Integer arraylist
        ArrayList<Integer> list=new ArrayList<Integer>();
        // for string arraylist
        ArrayList<String> list2=new ArrayList<String>();
        // add element
        list.add(0);
        list.add(20);
        list.add(3);
        System.out.println(list);
        int element= list.get(1);
        System.out.println(element);
        // add element in btw
        list.add(1,1);
        System.out.println(list);
        // set element
        list.set(0,5);
        System.out.println(list);
        // delete element
        list.remove(3);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            // sorting

        }
        Collections.sort(list);

    }
}
