/*
Noh Daniel
January 18th, 2026
A3Q2
Reads raw_marks.txt, stores the lines in an ArrayList then calculates the average mark for each student and
the average mark for each course, then outputs a separate report card for each student in a file named "(last name).txt".


*/

import java.io.*;
import java.util.*;

public class A3Q2 {

    // Method that reads the class report card file and stores each line into an ArrayList
    public static ArrayList<String> readFileLines(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();

        return lines;
    }

    // Removes the ':' at the end so it doesnt mess with getting integers, replaces with blank space
    public static String removeColon(String word) {
        if (word.endsWith(":")) {
            String newWord = "";
            for (int i = 0; i < word.length() - 1; i++) {
                newWord = newWord + word.charAt(i);
            }
            return newWord;
        }
        return word;
    }

    // Method that gets average than rounds it to nearest integer for the mark
    public static int getAverage(ArrayList<Integer> marks) {
        int sum = 0;

        for (Integer mark : marks) {
            sum = sum + mark;
        }

        return (int) Math.round((double) sum / marks.size());
    }

    // Method that calculates the course average using all students course average, also rounds it to nearest integer
    public static ArrayList<Integer> getCourseAverages(ArrayList<Integer> courseSums, int studentCount) {
        ArrayList<Integer> courseAverages = new ArrayList<>();

        for (Integer courseSum : courseSums) {
            int avg = (int) Math.round((double) courseSum / studentCount);
            courseAverages.add(avg);
        }

        return courseAverages;
    }

    // Method that calculates student's overall averages
    public static ArrayList<Integer> getStudentAverages(ArrayList<ArrayList<Integer>> allStudentMarks) {
        ArrayList<Integer> studentAverages = new ArrayList<>();

        for (ArrayList<Integer> allStudentMark : allStudentMarks) {
            int avg = getAverage(allStudentMark);
            studentAverages.add(avg);
        }

        return studentAverages;
    }

    // Method that writes a student's report card in a .txt file named after their last name
    public static void writeReportCard(String lastName, String firstName, ArrayList<String> courses, ArrayList<Integer> studentMarks, ArrayList<Integer> courseAverages, int studentAverage) throws IOException {

        // Output file name must be "(the last name here).txt", makes everything lowercase to make it uniform
        PrintWriter writer = new PrintWriter(lastName.toLowerCase() + ".txt");

        // The headers
        writer.println("Student Name: " + lastName + ", " + firstName);
        writer.println("Average Mark: " + studentAverage);
        writer.println();
        writer.println();

        // Table header that uses tab to make it like the template u gave us
        writer.println("Course:\t\tFinal Mark:\tCourse Average:");
        writer.println("======\t\t==========\t==============");

        // Prints each course row (course, student's mark, course average)
        for (int i = 0; i < courses.size(); i++) {
            String course = courses.get(i);
            int mark = studentMarks.get(i);
            int courseAvg = courseAverages.get(i);

            // spacing so the columns dont look messed up and r uniform
            if (course.length() >= 8) {
                writer.println(course + "\t" + mark + "\t\t" + courseAvg);
            } else {
                writer.println(course + "\t\t" + mark + "\t\t" + courseAvg);
            }
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {

        // Reads every line from raw_marks.txt and stores it in an ArrayList
        ArrayList<String> lines = readFileLines("raw_marks.txt");

        // Reads course header to get names
        Scanner headerScanner = new Scanner(lines.get(0));

        headerScanner.next(); // First
        headerScanner.next(); // Name:
        headerScanner.next(); // Last
        headerScanner.next(); // Name: reads all this to skip it and not include it in courses

        ArrayList<String> courses = new ArrayList<>();

        // reads the rest of the headers which should just be class names
        while (headerScanner.hasNext()) {
            String course = headerScanner.next();
            course = removeColon(course); // get rid of the colon

            // Incase average is in the header, we ignore it
            if (!course.equalsIgnoreCase("Average")) {
                courses.add(course);
            }
        }
        headerScanner.close();

        // Stores students and their marks
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();

        // Number of students
        int studentCount = lines.size() - 1;

        // Number of courses (how many course names we found in the header)
        int courseCount = courses.size();

        // 2D array that stores all marks and courses
        int[][] marks = new int[studentCount][courseCount];

        // For course averages, we need sums for each course
        ArrayList<Integer> courseSums = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            courseSums.add(0);
        }

        // Start at line 1 because line 0 is the header row
        int studentIndex = 0;
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {

            Scanner lineScanner = new Scanner(lines.get(lineIndex));

            // If the line is empty, skip it
            if (!lineScanner.hasNext()) {
                lineScanner.close();

                // If your file has empty lines, this keeps the program from crashing,
                continue;
            }

            // First two words are first name and last name
            String first = lineScanner.next();
            String last = lineScanner.next();

            // Store names in array lists
            firstNames.add(first);
            lastNames.add(last);

            // reads all marks up to the course amount
            for (int j = 0; j < courseCount; j++) {

                // Reads the marks
                int mark = lineScanner.nextInt();

                // Store mark into the 2D array
                marks[studentIndex][j] = mark;

                // Add this mark into the course sum for averages later
                courseSums.set(j, courseSums.get(j) + mark);
            }

            lineScanner.close();

            studentIndex++;
        }

        // Number of students
        studentCount = studentIndex;

        // Course averages
        ArrayList<Integer> courseAverages = getCourseAverages(courseSums, studentCount);

        // Student averages
        ArrayList<Integer> studentAverages = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {

            // gets all the students marks
            int sum = 0;
            for (int j = 0; j < courseCount; j++) {
                sum = sum + marks[i][j];
            }

            int avg = (int) Math.round((double) sum / courseCount);
            studentAverages.add(avg);
        }

        // Outputs the report cards
        for (int i = 0; i < studentCount; i++) {

            // Convert this student's row in the 2D array into an ArrayList because the writeReportCard expects one
            ArrayList<Integer> studentMarks = new ArrayList<>();
            for (int j = 0; j < courseCount; j++) {
                studentMarks.add(marks[i][j]);
            }

            writeReportCard(lastNames.get(i), firstNames.get(i), courses, studentMarks, courseAverages, studentAverages.get(i));
        }

        System.out.println("Report cards made");
    }
}
