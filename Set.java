public class Set {
    public static void main(String[] args) {
        java.util.HashSet<Integer> SetofRoll = new java.util.HashSet<>();

        // Adding some example roll numbers
        SetofRoll.add(101);
        SetofRoll.add(102);
        SetofRoll.add(103);
        SetofRoll.add(104);
        SetofRoll.add(105);
        // Print the set
        System.out.println("Set of Roll Numbers: " + SetofRoll);

        for (Integer roll : SetofRoll) {
            System.out.println("Roll Number: " + roll);
        }


    }
    
}
