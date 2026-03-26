// Noh Daniel
// A5Q1
// This program reads student marks from a file, lets the user add + remove + update students, and can show averages, highest marks, report cards, and a sorted class list.

import java.io.*;
import java.util.*;

public class A5Q1 {

    public static void main(String[] args) throws IOException {

        // Loads the students that already exist in the file
        ArrayList<Student> students = loadStudentsFromFile("raw_marks.txt");

        // Scanner for typing into the program
        Scanner input = new Scanner(System.in);

        // Keeps showing the menu until the user exits
        while (true) {

            printMenu();

            // Gets a valid menu option
            int option = getIntInRange(input, "Choose an option: ", 0, 8);

            // Exit
            if (option == 0) {
                System.out.println("Done");
                break;
            }

            // Runs the right menu choice
            if (option == 1) {
                addStudentMenu(input, students);
            }
            else if (option == 2) {
                removeStudentMenu(input, students);
            }
            else if (option == 3) {
                updateStudentMenu(input, students);
            }
            else if (option == 4) {
                averageStudentMenu(input, students);
            }
            else if (option == 5) {
                highestStudentMenu(input, students);
            }
            else if (option == 6) {
                printReportCardMenu(input, students);
            }
            else if (option == 7) {
                exportReportCardMenu(input, students);
            }
            else if (option == 8) {
                System.out.println(classList(students));
            }
        }

    }

    // Reads the file and turns each student line into a Student object
    public static ArrayList<Student> loadStudentsFromFile(String filename) throws IOException {

        ArrayList<Student> students = new ArrayList<>();
        Scanner reader = new Scanner(new File(filename));

        // Skips the first line stuff (the words at the top)
        for (int i = 0; i < 8 && reader.hasNext(); i++) {
            reader.next();
        }

        // Reads each student's first name, last name, then 4 marks
        while (reader.hasNext()) {

            String first = reader.next();
            String last = reader.next();

            int m1 = reader.nextInt();
            int m2 = reader.nextInt();
            int m3 = reader.nextInt();
            int m4 = reader.nextInt();

            students.add(new Student(first, last, m1, m2, m3, m4));
        }

        return students;
    }

    // Prints the menu
    public static void printMenu() {
        System.out.println(
                "1: Add a new Student\n" +
                        "2: Remove a Student\n" +
                        "3: Update a Student’s Info\n" +
                        "4: Show a Student’s Average Mark\n" +
                        "5: Show a Student’s Highest Mark\n" +
                        "6: Print a Student’s Report Card on the screen\n" +
                        "7: Print a Student’s Report Card to a file (<lastname>.txt)\n" +
                        "8: Print a Class List (sorted alphabetically by last name)\n" +
                        "0: Exit"
        );
    }

    // Makes sure the user types an integer in the allowed range
    public static int getIntInRange(Scanner input, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = input.nextInt();
                input.nextLine();

                if (value < min || value > max) {
                    System.out.println("Please enter a number from " + min + " to " + max + ".");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
                input.nextLine();
            }
        }
    }

    // Finds a student by first + last name (returns index, or -1 if not found)
    public static int findStudentIndex(ArrayList<Student> students, String first, String last) {
        for (int i = 0; i < students.size(); i++) {
            String full = students.get(i).getName(); // "Last, First"
            String[] parts = full.split(",");
            String fileLast = parts[0].trim();
            String fileFirst = parts[1].trim();

            if (fileFirst.equalsIgnoreCase(first.trim()) && fileLast.equalsIgnoreCase(last.trim())) {
                return i;
            }
        }
        return -1;
    }

    // Asks for first + last name, then returns index (or -1 if not found)
    public static int getStudentByName(Scanner input, ArrayList<Student> students, String prompt) {

        if (students.size() == 0) {
            System.out.println("There are no students in the list.");
            return -1;
        }

        System.out.println(prompt);
        System.out.print("First name: ");
        String first = input.nextLine().trim();

        System.out.print("Last name: ");
        String last = input.nextLine().trim();

        int idx = findStudentIndex(students, first, last);

        if (idx == -1) {
            System.out.println("That student is not in the class.");
            return -1;
        }

        System.out.println("You selected: " + students.get(idx).getName());
        return idx;
    }

    //Adds a student (and checks if they already exist)
    public static void addStudentMenu(Scanner input, ArrayList<Student> students) {

        System.out.print("Enter the first name of the student: ");
        String first = input.nextLine().trim();

        System.out.print("Enter the last name of the student: ");
        String last = input.nextLine().trim();

        // If student already exists, tell the user
        if (findStudentIndex(students, first, last) != -1) {
            System.out.println("That student already exists.");
            return;
        }

        int math = getIntInRange(input, "Enter the math mark of the student: ", 0, 100);
        int english = getIntInRange(input, "Enter the english mark of the student: ", 0, 100);
        int science = getIntInRange(input, "Enter the science mark of the student: ", 0, 100);
        int art = getIntInRange(input, "Enter the art mark of the student: ", 0, 100);

        students.add(new Student(first, last, math, english, science, art));
        System.out.println("Student added.");
    }

    // Removes a student
    public static void removeStudentMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want to remove?");
        if (idx == -1) {
            return;
        }

        students.remove(idx);
        System.out.println("Student removed.");
    }

    // updates a student's info
    public static void updateStudentMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want to update?");
        if (idx == -1) {
            return;
        }

        System.out.print("Enter the new first name: ");
        String first = input.nextLine().trim();

        System.out.print("Enter the new last name: ");
        String last = input.nextLine().trim();

        // If they change the name into a name that already exists (and it's not the same student)
        int check = findStudentIndex(students, first, last);
        if (check != -1 && check != idx) {
            System.out.println("That student already exists.");
            return;
        }

        int math = getIntInRange(input, "Enter the math mark of the student: ", 0, 100);
        int english = getIntInRange(input, "Enter the English mark of the student: ", 0, 100);
        int science = getIntInRange(input, "Enter the science mark of the student: ", 0, 100);
        int art = getIntInRange(input, "Enter the art mark of the student: ", 0, 100);

        Student s = students.get(idx);
        s.setName(first, last);
        s.setMark(1, math);
        s.setMark(2, english);
        s.setMark(3, science);
        s.setMark(4, art);

        System.out.println("Student updated.");
    }

    // prints the average
    public static void averageStudentMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want the average for?");
        if (idx == -1) {
            return;
        }

        System.out.println("The average of the student is: " + students.get(idx).getAverage());
    }

    // shows the highest mark
    public static void highestStudentMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want the highest mark for?");
        if (idx == -1) {
            return;
        }

        System.out.println("The highest mark of the student is: " + students.get(idx).getHighestMark());
    }

    // Prints the report card to the screen
    public static void printReportCardMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want the report card for?");
        if (idx == -1) {
            return;
        }

        System.out.println(students.get(idx).toString());
    }

    //Saves the report card into a file named after the student's last name
    public static void exportReportCardMenu(Scanner input, ArrayList<Student> students) {

        int idx = getStudentByName(input, students, "Who do you want the report card file for?");
        if (idx == -1) {
            return;
        }

        Student s = students.get(idx);

        String lastName = s.getName().split(",")[0].trim();

        try {
            PrintWriter writer = new PrintWriter(lastName + ".txt");
            writer.println(s.toString());
            writer.close();
            System.out.println("Exported report card to " + lastName + ".txt");
        } catch (Exception e) {
            System.out.println("Could not write the file.");
        }
    }

    //Returns a sorted list of names (doesn't change the original list)
    public static String classList(ArrayList<Student> students) {

        ArrayList<Student> copy = new ArrayList<>(students);

        Collections.sort(copy, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return a.getName().compareToIgnoreCase(b.getName());
            }
        });

        String out = "";
        for (int i = 0; i < copy.size(); i++) {
            out = out + (i + 1) + ": " + copy.get(i).getName();
            if (i < copy.size() - 1){
                out = out + "\n";
            }
        }

        return out;
    }
}