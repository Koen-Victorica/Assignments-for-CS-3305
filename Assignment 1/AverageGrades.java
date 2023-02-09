import java.util.Scanner;
// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 1
public class AverageGrades {
    //main method dispays the menu and allows you to choose your input
    public static void main(String[] args) {
        boolean end = false;
        Scanner scan = new Scanner(System.in);
        int choice, size, grade, student = 1;
        System.out.println("Enter the class size: ");
        size = Integer.parseInt(scan.nextLine()); // stores how large your class is
        int[] classgrades = new int[size];  // creates an array of size of your choice
        do { // poulates the array of size of your choice
            System.out.println("Enter the grade for student " + student + ": ");
            grade = Integer.parseInt(scan.nextLine());
            while (grade < 0 || grade > 100){ // if the number is not between 0 and 100 enter a new value
                System.out.println("Please enter a grade between 0 - 100 for student " + student + ": ");
                grade = Integer.parseInt(scan.nextLine());
            }
            classgrades[student-1] = grade;
            student++;
        } while (student-1 < size);
        do{ // menu loop
            System.out.println("\n--------MAIN MENU-------\n" +
                    "1. Read class size\n" +
                    "2. Read class grades\n" +
                    "3. Compute class average\n" +
                    "4. Exit program\n\n" +
                    "Enter option number: ");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 1: // tells you the class size you chose
                    System.out.println("\nYou entered class size: " + size);
                    break;
                case 2: // displays all your grades you entered
                    System.out.print("\nYou entered grades: ");
                    for (int num: classgrades) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 3: // displays the average by calling the findAverage method
                    System.out.println("\nClass average: " + String.format("%.2f",findAverage(classgrades, 0)));
                    break;
                case 4: // ends the do while loop
                    end = true;
                    break;
                default: // tells you to enter a valid input
                    end = false;
                    System.out.println("\nPlease enter a valid input");
                    break;
            }
        } while (end == false);
    }
    // adds all your grades and then divides the sum by the total number of grades entered
    public static double findAverage(int[] grade, int i) {
        if (i == grade.length-1){ // if it is the last element of the array return the integer stored
            return grade[i];
        }
        if (i == 0){ // if it is the first element of the array call the method for the next element, add this element and then lastly divide by the total number of elements
            return (grade[i] + findAverage(grade, i + 1)) / (grade.length);
        }
        // if it is the first element of the array call the method for the next element and add this element
        return grade[i] + findAverage(grade, i + 1);
    }
}