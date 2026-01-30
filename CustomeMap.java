public class CustomeMap {
    
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    class Custommap<K, V> {
        private Node<K, V>[] buckets;
        private int capacity;
        private int size;
        private static final int DEFAULT_CAPACITY = 16;
        private static final float LOAD_FACTOR = 0.75f;
        
        @SuppressWarnings("unchecked")
        public Custommap() {
            this.capacity = DEFAULT_CAPACITY;
            this.buckets = new Node[capacity];
            this.size = 0;
        }
        
        @SuppressWarnings("unchecked")
        public Custommap(int capacity) {
            this.capacity = capacity;
            this.buckets = new Node[capacity];
            this.size = 0;
        }
        
        private int hash(K key) {
            if (key == null) return 0;
            return Math.abs(key.hashCode()) % capacity;
        }
        
        public void put(K key, V value) {
            if (size >= capacity * LOAD_FACTOR) {
                resize();
            }
            
            int index = hash(key);
            Node<K, V> node = buckets[index];
            
            // Check if key already exists
            while (node != null) {
                if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            
            // Add new node at the beginning
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
        
        public V get(K key) {
            int index = hash(key);
            Node<K, V> node = buckets[index];
            
            while (node != null) {
                if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }
        
        public V remove(K key) {
            int index = hash(key);
            Node<K, V> node = buckets[index];
            Node<K, V> prev = null;
            
            while (node != null) {
                if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                    if (prev == null) {
                        buckets[index] = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    size--;
                    return node.value;
                }
                prev = node;
                node = node.next;
            }
            return null;
        }
        
        public boolean containsKey(K key) {
            return get(key) != null;
        }
        
        public int size() {
            return size;
        }
        
        @SuppressWarnings("unchecked")
        private void resize() {
            int newCapacity = capacity * 2;
            Node<K, V>[] oldBuckets = buckets;
            buckets = new Node[newCapacity];
            capacity = newCapacity;
            size = 0;
            
            for (Node<K, V> node : oldBuckets) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        CustomeMap customMap = new CustomeMap();
        Custommap<String, Integer> map = customMap.new Custommap<>();
        
        // Test put
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        
        // Test get
        System.out.println("Value for 'apple': " + map.get("apple"));
        System.out.println("Value for 'banana': " + map.get("banana"));
        System.out.println("Size: " + map.size());
        
        // Test update
        map.put("apple", 15);
        System.out.println("Updated value for 'apple': " + map.get("apple"));
        
        // Test containsKey
        System.out.println("Contains 'cherry': " + map.containsKey("cherry"));
        System.out.println("Contains 'grape': " + map.containsKey("grape"));
        
        // Test remove
        System.out.println("Removed 'banana': " + map.remove("banana"));
        System.out.println("Size after removal: " + map.size());
        System.out.println("Value for 'banana' after removal: " + map.get("banana"));
    }
    
}
