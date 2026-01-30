public class SetMap {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> data = new java.util.HashMap<>();
        data.put(1, "Apple");
        data.put(2, "Banana");
        data.put(3, "Cherry");
        data.put(2, "Date"); 

        for (Integer key : data.keySet()) {
            System.out.println("Key: " + key + ", Value: " + data.get(key));
        }

        java.util.HashSet<String> uniqueFruits = new java.util.HashSet<>();
        for(String fruit : data.values()) {
            uniqueFruits.add(fruit);
        }

        for (String fruit : uniqueFruits) {
            System.out.println("Unique Fruit: " + fruit);
        }
        
    }
    
}
