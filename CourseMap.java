public class CourseMap {
    public static void main(String[] args) {
        java.util.HashMap<String, String> courseMap = new java.util.HashMap<>();
        // Add some example entries with action time as key and course name as value
        courseMap.put("9:00 AM", "Mathematics");
        courseMap.put("10:30 AM", "Physics");
        courseMap.put("2:00 PM", "Chemistry");
        courseMap.put("4:00 PM", "Biology");

        // Print the map
        System.out.println("Course Schedule:");
        for (String time : courseMap.keySet()) {
            System.out.println(time + " - " + courseMap.get(time));
        }
    }
}
