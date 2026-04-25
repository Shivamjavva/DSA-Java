package Hashing;
import java.util.LinkedList;
import java.util.ArrayList;

public class implementation {
    static class HashMap<K, V> {

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;       // number of elements
        private int N;       // number of buckets
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();  // ✅ Fixed: was missing initialization
            }
        }

        // ✅ Fixed: return type added, correct types used
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // ✅ Fixed: correct type K, use .equals() instead of ==
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N = N * 2;                              // ✅ Fixed: update N before reassigning
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            n = 0;                                  // ✅ Fixed: reset count before re-inserting
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                buckets[bi].add(new Node(key, value));  // ✅ Fixed: was passing 'bi' instead of 'value'
                n++;
            } else {
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        // ✅ Fixed: fully implemented
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            }
            return buckets[bi].get(di).value;
        }

        // ✅ Fixed: fully implemented
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            }
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }

        // ✅ Fixed: fully implemented
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // ✅ Fixed: correct logic
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        map.put("date", 4);
        map.put("elderberry", 5); // triggers rehash (lambda > 2.0)

        System.out.println("Get apple: " + map.get("apple"));       // 1
        System.out.println("Get banana: " + map.get("banana"));     // 2

        map.put("apple", 99);
        System.out.println("Updated apple: " + map.get("apple"));   // 99

        System.out.println("Keys: " + map.keySet());

        map.remove("banana");
        System.out.println("After removing banana: " + map.get("banana")); // null

        System.out.println("Is empty: " + map.isEmpty()); // false
    }
}
// hashmap internally implement internally  as an array;