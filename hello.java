class MyTask implements Runnable {
    void displayHello() {
        System.out.println("Hello ");
    }
    void displayHii() {
        System.out.println("Hii");
    }
    @Override
    public void run() {
        displayHello();
        displayHii();
    }
}

class VishalList<T> {
    private Object[] items;
    private int size;
    private int capacity;
    
    public VishalList() {
        this.capacity = 10;
        this.items = new Object[capacity];
        this.size = 0;
    }
    
    public void addItem(T item) {
     
        if (size >= capacity) {
            capacity *= 2;
            Object[] newItems = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[size] = item;
        size++;
    }
    
    @SafeVarargs
    public final void addItems(T... multipleItems) {
        for (T item : multipleItems) {
            addItem(item);
        }
    }
    
    public void removeItem(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].equals(item)) {

                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null;
                size--;
                return;
            }
        }
    }
    
    public void displayItems() {
        System.out.print("Items: [");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public int getSize() {
        return size;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public T getItem(int index) {
        if (index >= 0 && index < size) {
            return (T) items[index];
        }
        return null;
    }
}

class DuplicateHandler<T> {
    private VishalList<T> list;
    
    public DuplicateHandler(VishalList<T> list) {
        this.list = list;
    }
    
    // Get all duplicate elements
    public VishalList<T> getDuplicates() {
        VishalList<T> duplicates = new VishalList<>();
        VishalList<T> seen = new VishalList<>();
        VishalList<T> foundDuplicates = new VishalList<>();
        
        for (int i = 0; i < list.getSize(); i++) {
            T item = list.getItem(i);
            boolean isInSeen = false;
            
            // Check if item is in seen list
            for (int j = 0; j < seen.getSize(); j++) {
                if (seen.getItem(j) != null && seen.getItem(j).equals(item)) {
                    isInSeen = true;
                    break;
                }
            }
            
            if (!isInSeen) {
                // Check if this item appears more than once in original list
                int count = 0;
                for (int j = 0; j < list.getSize(); j++) {
                    if (list.getItem(j) != null && list.getItem(j).equals(item)) {
                        count++;
                    }
                }
                
                if (count > 1) {
                    duplicates.addItem(item);
                }
                seen.addItem(item);
            }
        }
        
        return duplicates;
    }
    
    // Remove all duplicate elements (keep only one occurrence of each)
    public VishalList<T> removeDuplicates() {
        VishalList<T> unique = new VishalList<>();
        
        for (int i = 0; i < list.getSize(); i++) {
            T item = list.getItem(i);
            boolean found = false;
            
            for (int j = 0; j < unique.getSize(); j++) {
                if (unique.getItem(j) != null && unique.getItem(j).equals(item)) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                unique.addItem(item);
            }
        }
        
        return unique;
    }
    
    // Display duplicates
    public void displayDuplicates() {
        VishalList<T> dups = getDuplicates();
        System.out.print("Duplicate Elements: [");
        for (int i = 0; i < dups.getSize(); i++) {
            System.out.print(dups.getItem(i));
            if (i < dups.getSize() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Duplicate Count: " + dups.getSize());
    }
}

public class hello {
    public static void main(String[] args) {

        MyTask task = new MyTask();   

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        // t1.start();
        // t2.start();
        
        VishalList<String> list = new VishalList<>();
        list.addItem("Java");
        list.addItem("Python");
        list.addItem("C++");
        list.displayItems();
        list.addItems("Hello", "Sukh", "C", "Dart", "Rust", "Go", "Node","hello");
        System.out.println("Size: " + list.getSize());
        System.out.println("Capacity: " + list.getCapacity());
        
        // Integer list
        VishalList<Integer> intList = new VishalList<>();
        intList.addItems(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120);
        System.out.println("\nInteger List:");
        intList.displayItems();
        System.out.println("Size: " + intList.getSize());
        System.out.println("Capacity: " + intList.getCapacity());
        
        // Boolean list
        VishalList<Boolean> boolList = new VishalList<>();
        boolList.addItems(true, false, true, true, false);
        System.out.println("\nBoolean List:");
        boolList.displayItems();
        System.out.println("Size: " + boolList.getSize());
        
        // Double list
        VishalList<Double> doubleList = new VishalList<>();
        doubleList.addItems(1.5, 2.5, 3.5, 4.5, 5.5);
        System.out.println("\nDouble List:");
        doubleList.displayItems();
        
        // Duplicate Handler Demo
        System.out.println("\n--- DUPLICATE HANDLER DEMO ---");
        VishalList<String> stringListWithDuplicates = new VishalList<>();
        stringListWithDuplicates.addItems("Apple", "Banana", "Apple", "Cherry", "Banana", "Date", "Apple", "Cherry");
        System.out.println("\nOriginal List with Duplicates:");
        stringListWithDuplicates.displayItems();
        System.out.println("Size: " + stringListWithDuplicates.getSize());
        System.out.println("Capacity: " + stringListWithDuplicates.getCapacity());
        
        DuplicateHandler<String> handler = new DuplicateHandler<>(stringListWithDuplicates);
        handler.displayDuplicates();
        
        System.out.println("\nList After Removing Duplicates:");
        VishalList<String> uniqueList = handler.removeDuplicates();
        uniqueList.displayItems();
        System.out.println("Size: " + uniqueList.getSize());
        System.out.println("Capacity: " + uniqueList.getCapacity());
        
        // Integer list with duplicates
        System.out.println("\n--- Integer List with Duplicates ---");
        VishalList<Integer> intListDup = new VishalList<>();
        intListDup.addItems(5, 10, 5, 15, 10, 20, 5, 25, 10);
        System.out.println("Original Integer List:");
        intListDup.displayItems();
        
        DuplicateHandler<Integer> intHandler = new DuplicateHandler<>(intListDup);
        intHandler.displayDuplicates();
        
        System.out.println("Integer List After Removing Duplicates:");
        VishalList<Integer> uniqueIntList = intHandler.removeDuplicates();
        uniqueIntList.displayItems();
        System.out.println("Size: " + uniqueIntList.getSize());
    }
}
