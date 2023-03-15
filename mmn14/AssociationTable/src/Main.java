import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Student[] students = {
                new Student("Moshe", "Cohen", 321654987, 2000),
                new Student("Maya", "Koch", 312456789, 1999),
                new Student("Anna", "Karenina", 331789456, 1985)
        };
        String[] phones = {"054-1234567", "050-7654321", "058-9876543"};

        try {
        AssociationTable<Student,String> data = new AssociationTable(students, phones);
        data.add(new Student("Elsa", "Queen", 234789333, 2003), "054-2019999");
            data.add(students[1], "052-1234567");
            data.remove(students[0]);

            Student st;
            for (Iterator<Student> it = data.keyIterator(); it.hasNext(); ) {
                st = it.next();
                System.out.println(st + ", tel. " + data.get(st));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Amount of students and phone numbers are not equal.");
        }
    }
}
