// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 4
import java.util.Scanner;
public class RadixSort {
    public static int s = 0; //used to count digit
    public static Queue Q0 = new Queue(), Q1 = new Queue(), Q2 = new Queue(), Q3 = new Queue(), Q4 = new Queue(), Q5 = new Queue(), Q6 = new Queue(), Q7 = new Queue(), Q8 = new Queue(), Q9 = new Queue(); //creates the queues for the Radix sort
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputs = null;
        int input = 0, choice = 0;
        char YN = 'n';
        do { // displays the menu
            System.out.println();
            System.out.println("How many input values: ");
            choice = Integer.parseInt(scan.nextLine());
            inputs = new int[choice];
            System.out.println();
            for(int i = 0; i < choice; i++) { // populates array
                System.out.println("Input integer " + (i + 1) + ": ");
                input = Integer.parseInt(scan.nextLine());
                while (input < 0){
                    System.out.println("Integer must be a positive number: ");
                    input = Integer.parseInt(scan.nextLine());
                }
                inputs[i] = input;
            }
            System.out.println();
            System.out.print("Inputs array before sorting: ");
            for (int i: inputs) { // prints array
                System.out.print(i + "  ");
            }
            System.out.println();
            if (inputs != null){
                ExtractDigit(inputs, choice);
            }
            System.out.println();
            System.out.print("Inputs array after sorting: ");
            for (int i: inputs) { // prints array
                System.out.print(i + "  ");
            }
            System.out.println();
            do {
                System.out.println();
                System.out.println("Do you want to re-run code with different input string (Y/N)?"); // lets you quit the program, or you can run the program again
                YN = scan.nextLine().toLowerCase().charAt(0);
                if (YN == 'n') {
                    System.out.println();
                    System.out.println("Exiting...");
                    break;
                } else if (YN == 'y') {
                    inputs = null;
                    s = 0;
                    break;
                }
            } while (YN != 'Y' || YN != 'Y');
        } while (YN != 'n');
    }
    public static void ExtractDigit(int[] inputs, int choice){
        int key = 0;
        boolean finished = true;
        do {
            finished = true;
            for (int n : inputs) { //sorts each data stored into the array to it's correct queue
                key = (n / DigitCount()) % 10;
                switch (key) {
                    case 0:
                        Q0.enqueue(n);
                        break;
                    case 1:
                        Q1.enqueue(n);
                        break;
                    case 2:
                        Q2.enqueue(n);
                        break;
                    case 3:
                        Q3.enqueue(n);
                        break;
                    case 4:
                        Q4.enqueue(n);
                        break;
                    case 5:
                        Q5.enqueue(n);
                        break;
                    case 6:
                        Q6.enqueue(n);
                        break;
                    case 7:
                        Q7.enqueue(n);
                        break;
                    case 8:
                        Q8.enqueue(n);
                        break;
                    case 9:
                        Q9.enqueue(n);
                        break;
                }
            }
            s++;
            for (int i = 0; i < choice; i++) { //repopulates the array starting with Q0 then Q1 then Q2... Q9 if Q0 is the only Queue used end this method
                if (Q0.isEmpty() == false) {
                    inputs[i] = (int) Q0.dequeue();
                } else if (Q1.isEmpty() == false) {
                    inputs[i] = (int) Q1.dequeue();
                    finished = false;
                } else if (Q2.isEmpty() == false) {
                    inputs[i] = (int) Q2.dequeue();
                    finished = false;
                } else if (Q3.isEmpty() == false) {
                    inputs[i] = (int) Q3.dequeue();
                    finished = false;
                } else if (Q4.isEmpty() == false) {
                    inputs[i] = (int) Q4.dequeue();
                    finished = false;
                } else if (Q5.isEmpty() == false) {
                    inputs[i] = (int) Q5.dequeue();
                    finished = false;
                } else if (Q6.isEmpty() == false) {
                    inputs[i] = (int) Q6.dequeue();
                    finished = false;
                } else if (Q7.isEmpty() == false) {
                    inputs[i] = (int) Q7.dequeue();
                    finished = false;
                } else if (Q8.isEmpty() == false) {
                    inputs[i] = (int) Q8.dequeue();
                    finished = false;
                } else if (Q9.isEmpty() == false) {
                    inputs[i] = (int) Q9.dequeue();
                    finished = false;
                }
            }
        } while (finished == false);
    }

    public static int DigitCount(){ // selects the ones slot or tens slot and so on
        int digit = 1;
        for (int i = 0; i < s ; i++){
            digit = digit * 10;
        }
        return digit;
    }
}