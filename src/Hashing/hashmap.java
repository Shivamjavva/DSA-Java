package Hashing;
import java.util.*;
public class hashmap {
    public static void main(String[] args) {
        // store key value pair // key is unique
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",124);
        map.put("us",222);
        map.put("China",150);
        System.out.println(map);
        // value upd
        map.put("china",333);
        System.out.println(map);
        // search in hashmap
        if(map.containsKey("china")){
            System.out.println("key is present in the map");
        }
        else{
            System.out.println("key is not present in the map");
        }
        System.out.println(map.get("china"));
        System.out.println(map.get("srilanka"));
        int arr[]={12,13,14};
        for(int val:arr){
            System.out.println(val+"");
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey());
        }

    }
}
//