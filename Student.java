public class Student {
    // declaring the instance variables
    private String firstName;
    private String lastName;
    private int mark1;
    private int mark2;
    private int mark3 ;
    private int mark4;

    // Default, everything is 0 or empty
    public Student() {
        firstName = "";
        lastName = "";
        mark1 = 0;
        mark2 = 0;
        mark3 = 0;
        mark4 = 0;
    }

    // Full constructor with everything being assigned
    public Student(String f, String l, int m1, int m2, int m3, int m4) {
        firstName = f;
        lastName = l;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
        mark4 = m4;
    }

    // Sets the name of the student
    public void setName(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // Returns the name of the student
    public String getName() {
        return lastName + ", " + firstName;
    }

    // Sets mark for course 1-4
    public void setMark(int course, int mark) {
        if (course == 1) mark1 = mark;
        else if (course == 2) mark2 = mark;
        else if (course == 3) mark3 = mark;
        else if (course == 4) mark4 = mark;
    }

    // Returns mark for course 1-4
    public int getMark(int course) {
        if (course == 1) return mark1;
        if (course == 2) return mark2;
        if (course == 3) return mark3;
        if (course == 4) return mark4;
        return -1; // for invalid courses
    }

    // Returns average of the 4 marks
    public int getAverage() {
        return (mark1 + mark2 + mark3 + mark4) / 4;
    }

    // Returns the student's highest mark
    public int getHighestMark() {
        int best = mark1;
        if (mark2 > best) best = mark2;
        if (mark3 > best) best = mark3;
        if (mark4 > best) best = mark4;
        return best;
    }

    // returns report card
    public String toString() {
        return "Student Name: " + getName() + "\n"
                + "Average Mark: " + getAverage() + "\n\n"
                + "Course:\t\tFinal Mark:\t\n"
                + "======\t\t==========\t\n"
                + "Math\t\t" + mark1 + "\t\t\t\n"
                + "English\t\t" + mark2 + "\t\t\t\n"
                + "Science\t\t" + mark3 + "\t\t\t\n"
                + "Art\t\t" + mark4 + "\t\t\t\n";
    }
}
