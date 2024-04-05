
public class Main {
    public static void main(String[] args) {
        // Create a few Student objects with different constructors
        Student student1 = new Student();
        Student student2 = new Student(true);
        Student student3 = new Student("Computer Science", false);
        Student student4 = new Student("Alice", 1998, "Biology", true);

        // Display information about the students
        System.out.println("Student 1:\n" + student1.toString());
        System.out.println("\nStudent 2:\n" + student2.toString());
        System.out.println("\nStudent 3:\n" + student3.toString());
        System.out.println("\nStudent 4:\n" + student4.toString());

        // Compare students based on the number of courses taken
        int comparisonResult = student1.compareTo(student2);
        System.out.println("\nComparison between Student 1 and Student 2 based on courses taken: " + comparisonResult);
    }
}

