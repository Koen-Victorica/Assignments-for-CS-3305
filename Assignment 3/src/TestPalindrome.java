// Name: Sam Victorica
// Class: CS 3305 Section#: W03
// Term: Spring 2023
// Instructor: Prof. Majeed
// Assignment: 3
import java.util.Scanner;
public class TestPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack myStack = new Stack();
        String[] words = null;
        String input = null, rev ="";
        char YN = 'n';
        do{ // displays the menu
            System.out.println();
            System.out.println("Enter a string: ");
            input = scan.nextLine();
            System.out.println();
            System.out.println("Input String: " + input);
            System.out.println();
            words = input.split(""); // separates the users input into separate characters
            for (String word : words) { //populates the stack with the different characters
                myStack.Push(word);
            }
            for (String word : words) { //after the stack is filled with all the character in reverse order populates a string with those characters
                rev = rev + myStack.Pop();
            }
            System.out.print("Judgment: ");
            if (rev.equals(input)) // compares the new reversed string with the original; if they are the same it is a palindrome
                System.out.println("Palindrome");
            else
                System.out.println(" Not Palindrome");
            do {
                System.out.println();
                System.out.println("Do you want to re-run code with different input string (Y/N)?"); // lets you quit the program, or you can run the program again
                YN = scan.nextLine().toLowerCase().charAt(0);
                if(YN == 'n'){
                    System.out.println();
                    System.out.println("Exiting...");
                    break;
                } else if (YN == 'y') {
                    myStack.Clear();
                    words = null;
                    rev = "";
                    break;
                }
            }while (YN != 'Y' || YN != 'Y');
        } while (YN != 'n');
    }
}