import java.util.Objects;

/**
 * This class represent a Student
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 01/01/2022
 */

public class Student implements Comparable<Student> {
    private String _firstName;
    private String _lastName;
    private final int _id;
    private final int _bYear;

    //constructors
    /**
     * Constructs a student
     */
    public Student(String firstName, String lastName, int id, int bYear) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._id = id;
        this._bYear = bYear;
    }

    //setters and getters
    /**
     * Sets the new student's first name
     * @param newFirstName - the new student's first name
     */
    public void setFirstName(String newFirstName) {
        _firstName = newFirstName;
    }

    /**
     * Sets the new student's last name
     * @param newLastName - the new student's last name
     */
    public void setLastName(String newLastName) {
        _lastName = newLastName;
    }

    /**
     * Returns the student's first name
     * @return the student's first name
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     * Returns the student's last name
     * @return the student's last name
     */
    public String getLastName() {
        return _lastName;
    }

    /**
     * Returns the student's id
     * @return the student's id
     */
    public int getId() {
        return _id;
    }

    /**
     * Returns the student's year of birth
     * @return the student's year of birth
     */
    public int getBYear() {
        return _bYear;
    }

    /**
     * Compares this student with the specified student for order by their id
     * @param st - the student to be compared
     * @return a negative integer, zero, or a positive integer as this student's id is less than, equal to, or greater
     * than the specified student's id.
     */
    @Override
    public int compareTo(Student st) {
        return (this._id - st.getId());
    } //end of method compareTo

    /**
     * Indicates whether some other object is "equal to" this student.
     * @param obj - the reference object with which to compare
     * @return true if this student is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return this._id == student.getId();
    } //end of method equals

    /**
     * Returns a hash code value for this student.
     * @return a hash code value for this student.
     */
    @Override
    public int hashCode() {
        return Objects.hash(_id);
    } //end of method hashCode

    /**
     * Returns a string representation of the student
     * @return a string representation of the student.
     */
    @Override
    public String toString() {
        return _firstName + " " + _lastName + ", ID " + _id + ", year of birth " + _bYear;
    } //end of a method toString
} //end of class Student
